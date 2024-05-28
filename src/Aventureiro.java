import java.util.ArrayList;

public class Aventureiro {

    private String nome;
    private int pontos = 0;
    private int x;
    private int y;
    private String localizacaoAtual;
    private ArrayList<String> tesourosColetados;

    public Aventureiro(String nome, String localizacaoAtual) {
        this.nome = nome;
        this.x = 0;
        this.y = 0;
        this.localizacaoAtual = localizacaoAtual;
        this.tesourosColetados = new ArrayList<>();
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPosicaoX() {
        return x;
    }

    public void setPosicaoX(int posicaoX) {
        this.x = posicaoX;
    }

    public void setPosicaoY(int posicaoY) {
        this.y = posicaoY;
    }

    public int getPosicaoY() {
        return y;
    }

    public String getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    public void setLocalizacaoAtual(String localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
    }

    public void incrementarPontos(int pontos) {
        if (isValid(pontos)) {
            this.pontos += pontos;
        }
    }

    public void diminuirVida(int dano) {
        if (isValid(dano)) {
            this.pontos -= dano;
        }
    }

    public ArrayList<String> getTesourosColetados() {
        return tesourosColetados;
    }

    // Métodos para mover-se pelo labirinto e coletar tesouro
    public void mover(String novaLocalizacao) {
        this.localizacaoAtual = novaLocalizacao;
    }

    public void coletarTesouro(String tesouro) {
        tesourosColetados.add(tesouro);
    }

    private boolean isValid(int value) {
        return this.pontos + value >= 0;
    }
}