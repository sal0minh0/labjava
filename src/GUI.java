import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    private static final int MAZE_PANEL_WIDTH = 400;
    private static final int MAZE_PANEL_HEIGHT = 400;

    private JFrame frame;
    private JButton btnUp, btnDown, btnLeft, btnRight;
    private JButton btnMove;
    private JLabel lblLocation;
    private JPanel mazePanel;
    private JTextArea txtMazeStructure;
    private Aventureiro aventureiro;
    private Labirinto labirinto;

    public GUI(Labirinto lab, Aventureiro avt) {
        this.labirinto = lab;
        this.aventureiro = avt;
        labirinto.gerarMaze();
        createGUI();
    }

    public JFrame getFrame() {
        return frame;
    }

    private void createGUI() {
        frame = new JFrame("Maze Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(new BorderLayout());
        labirinto.gerarMaze();

        btnUp = new JButton("\u2191");
        btnDown = new JButton("\u2193");
        btnLeft = new JButton("\u2190");
        btnRight = new JButton("\u2192");
        btnMove = new JButton("Mover");

        lblLocation = new JLabel("Localizacao: " + aventureiro.getLocalizacaoAtual());
        txtMazeStructure = new JTextArea();
        txtMazeStructure.setText(labirinto.toString());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnLeft);
        buttonPanel.add(btnUp);
        buttonPanel.add(btnDown);
        buttonPanel.add(btnRight);

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(btnMove, BorderLayout.WEST);
        frame.add(lblLocation, BorderLayout.EAST);
        frame.add(txtMazeStructure, BorderLayout.SOUTH);

        mazePanel = new MazePanel(labirinto, aventureiro);
        mazePanel.setPreferredSize(new Dimension(MAZE_PANEL_WIDTH, MAZE_PANEL_HEIGHT));
        frame.add(mazePanel, BorderLayout.CENTER);

        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveAdventurer(e);
            }
        });
        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveAdventurer(e);
            }
        });
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveAdventurer(e);
            }
        });
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveAdventurer(e);
            }
        });
        btnMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveAdventurer(e);
            }
        });

        frame.setVisible(true);
    }


    private void moveAdventurer(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton == btnUp) {
            aventureiro.setPosicaoY(aventureiro.getPosicaoY() - 1);
            aventureiro.setLocalizacaoAtual("Norte");
        } else if (clickedButton == btnDown) {
            aventureiro.setPosicaoY(aventureiro.getPosicaoY() + 1);
            aventureiro.setLocalizacaoAtual("Sul");
        } else if (clickedButton == btnLeft) {
            aventureiro.setPosicaoX(aventureiro.getPosicaoX() - 1);
            aventureiro.setLocalizacaoAtual("Oeste");
        } else if (clickedButton == btnRight) {
            aventureiro.setPosicaoX(aventureiro.getPosicaoX() + 1);
            aventureiro.setLocalizacaoAtual("Leste");
        }
        ((MazePanel) mazePanel).setAdventurerPosition(aventureiro.getPosicaoX(), aventureiro.getPosicaoY());
        ((MazePanel) mazePanel).repaint();
        lblLocation.setText(aventureiro.getLocalizacaoAtual());
        System.out.println("Voce se moveu para o: " + aventureiro.getLocalizacaoAtual());
    }
    
}