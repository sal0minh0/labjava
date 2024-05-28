import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.List;

public class Labirinto {
    private String[][] mazeStructure;
    private ArrayList<Tesouro> listaDeTesouros;
    private ArrayList<Perigo> listaDePerigos;

    public Labirinto() {
        mazeStructure = new String[10][10];
        listaDeTesouros = new ArrayList<>();
        listaDePerigos = new ArrayList<>();
        inicializarEstrutura();
        adicionarTesouros();
        adicionarPerigos();
        construirParedes();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mazeStructure[i][j] = "wall";
            }
        }
    }

    public String[][] getMazeStructure() {
        return mazeStructure;
    }

    public void setMazeStructure(String[][] mazeStructure) {
        this.mazeStructure = mazeStructure;
    }

    private void inicializarEstrutura() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mazeStructure[i][j] = "path";
            }
        }
    }

    public void updateMazeStructure(Aventureiro aventureiro) {
        int x = aventureiro.getPosicaoX();
        int y = aventureiro.getPosicaoY();
        mazeStructure[x][y] = "path";

        for (Tesouro tesouro : listaDeTesouros) {
            if (tesouro.getPosicaoX() == x && tesouro.getPosicaoY() == y) {
                listaDeTesouros.remove(tesouro);
                aventureiro.incrementarPontos(tesouro.getPontos());
                break;
            }
        }

        for (Perigo perigo : listaDePerigos) {
            if (perigo.getPosicaoX() == x && perigo.getPosicaoY() == y) {
                listaDePerigos.remove(perigo);
                aventureiro.diminuirVida(perigo.getDano());
                break;
            }
        }
    }

    private void adicionarTesouros() {
        for (Tesouro tesouro : listaDeTesouros) {
            int x = tesouro.getPosicaoX();
            int y = tesouro.getPosicaoY();
            mazeStructure[x][y] = "treasure";
        }
    }

    private void adicionarPerigos() {
        for (Perigo perigo : listaDePerigos) {
            int x = perigo.getPosicaoX();
            int y = perigo.getPosicaoY();
            mazeStructure[x][y] = "danger";
        }
    }

    private void construirParedes() {
        for (int i = 0; i < 10; i++) {
            mazeStructure[i][0] = "wall";
            mazeStructure[i][9] = "wall";
        }
        for (int j = 0; j < 10; j++) {
            mazeStructure[0][j] = "wall";
            mazeStructure[9][j] = "wall";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                switch (mazeStructure[i][j]) {
                    case "path":
                        sb.append("\uD83D\uDD35");
                        break;
                    case "wall":
                        sb.append("\uD83D\uDD34");
                        break;
                    case "treasure":
                        sb.append("\uD83D\uDC8E"); 
                        break;
                    case "danger":
                        sb.append("\u2620"); 
                        break;
                    default:
                        sb.append("\u2753");
                }
            }
            sb.append("\n"); 
        }
        return sb.toString();
    }

    public void gerarMaze() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mazeStructure[i][j] = "wall";
            }
        }

        Stack<Cell> stack = new Stack<>();

        int startX = (int) (Math.random() * 10);
        int startY = (int) (Math.random() * 10);
        Cell startCell = new Cell(startX, startY);
        stack.push(startCell);

        while (!stack.isEmpty()) {
            Cell currentCell = stack.pop();

            if (mazeStructure[currentCell.x][currentCell.y].equals("wall")) {
                mazeStructure[currentCell.x][currentCell.y] = "path";

                List<Cell> neighbors = getNeighbors(currentCell);

                Collections.shuffle(neighbors);

                for (Cell neighbor : neighbors) {
                    stack.push(neighbor);
                }
            }
        }

        adicionarTesouros();
        adicionarPerigos();
        construirParedes();
    }

    private List<Cell> getNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<>();

        if (cell.x > 0 && mazeStructure[cell.x - 1][cell.y].equals("wall")) {
            neighbors.add(new Cell(cell.x - 1, cell.y));
        }
        if (cell.x < 9 && mazeStructure[cell.x + 1][cell.y].equals("wall")) {
            neighbors.add(new Cell(cell.x + 1, cell.y));
        }
        if (cell.y > 0 && mazeStructure[cell.x][cell.y - 1].equals("wall")) {
            neighbors.add(new Cell(cell.x, cell.y - 1));
        }
        if (cell.y < 9 && mazeStructure[cell.x][cell.y + 1].equals("wall")) {
            neighbors.add(new Cell(cell.x, cell.y + 1));
        }

        return neighbors;
    }

    private class Cell {
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void adicionarTesouro(Tesouro tesouro) {
        listaDeTesouros.add(tesouro);
    }

    public void adicionarPerigo(Perigo perigo) {
        listaDePerigos.add(perigo);
    }
}