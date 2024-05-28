import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MazePanel extends JPanel {
    private Labirinto labirinto;
    private Aventureiro aventureiro;
    private int adventurerX;
    private int adventurerY;

    public MazePanel(Labirinto labirinto, Aventureiro aventureiro) {
        this.labirinto = labirinto;
        this.aventureiro = aventureiro;
        this.adventurerX = aventureiro.getPosicaoX() * 60 + 100;
        this.adventurerY = aventureiro.getPosicaoY() * 60 + 100;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        String[][] maze = labirinto.getMazeStructure();

        if (maze == null || maze.length == 0) {
            return;
        }
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int mazeWidth = maze.length * 60;
        int mazeHeight = maze[0].length * 60;

        int x = (panelWidth - mazeWidth) / 2;
        int y = (panelHeight - mazeHeight) / 2;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                switch (maze[i][j]) {
                    case "path":
                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(x + j * 60, y + i * 60, 60, 60);
                        break;
                    case "wall":
                        g2d.setColor(Color.GRAY);
                        g2d.fillRect(x + j * 60, y + i * 60, 60, 60);
                        break;
                    case "treasure":
                        g2d.setColor(Color.YELLOW);
                        g2d.fillRect(x + j * 60, y + i * 60, 60, 60);
                        break;
                    case "danger":
                        g2d.setColor(Color.RED);
                        g2d.fillRect(x + j * 60, y + i * 60, 60, 60);
                        break;
                    case "block":
                        g2d.setColor(Color.BLACK);
                        g2d.fillRect(x + j * 60, y + i * 60, 60, 60);
                        break;
                }
            }
        }

        g2d.setColor(Color.BLACK);
        for (int i = 0; i <= maze.length; i++) {
            g2d.drawLine(x, y + i * 60, x + mazeWidth, y + i * 60);
        }

        for (int j = 0; j <= maze[0].length; j++) {
            g2d.drawLine(x + j * 60, y, x + j * 60, y + mazeHeight);
        }

        g2d.setColor(Color.RED);
        g2d.fillOval(adventurerX - 20, adventurerY - 20, 40, 40);
    }

    public void setAdventurerPosition(int x, int y) {
        adventurerX = x * 60 + 100;
        adventurerY = y * 60 + 100;
        repaint();
    }
}