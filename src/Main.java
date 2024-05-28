public class Main {
    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto(); 

        Aventureiro aventureiro = new Aventureiro("Bravo Aventureiro", "Começo");

        System.out.println("Bem-vindo ao Maze Generator, " + aventureiro.getNome() + "!");

        aventureiro.mover("Labirinto");
        System.out.println("Você se moveu para: " + aventureiro.getLocalizacaoAtual());

        aventureiro.coletarTesouro("Moeda de Ouro");
        System.out.println("Você começa com um tesouro: " + aventureiro.getTesourosColetados().get(0));

        labirinto.gerarMaze();

        GUI gui = new GUI(new Labirinto(), aventureiro = new Aventureiro("Bravo Aventureiro", "Começo"));
        gui.getFrame().setVisible(true);
    }
}