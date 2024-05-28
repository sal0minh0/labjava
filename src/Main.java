public class Main {
    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto(); 

        Aventureiro aventureiro = new Aventureiro("Bravo Aventureiro", "Comeco");

        System.out.println("Bem-vindo ao Maze Generator, " + aventureiro.getNome() + "!");

        aventureiro.mover("Labirinto");
        System.out.println("Voce se moveu para: " + aventureiro.getLocalizacaoAtual());

        aventureiro.coletarTesouro("Moeda de Ouro");
        System.out.println("Voce comeca com um tesouro: " + aventureiro.getTesourosColetados().get(0));

        labirinto.gerarMaze();

        GUI gui = new GUI(new Labirinto(), aventureiro = new Aventureiro("Bravo Aventureiro", "Comeco"));
        gui.getFrame().setVisible(true);

    }
}