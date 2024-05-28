public class Perigo extends Tesouro {

    private int dano;

    public Perigo(String localizacaoNoLabirinto, int danoPotencial, int posicaoX, int posicaoY) {
        super(localizacaoNoLabirinto, danoPotencial, posicaoX, posicaoY);
    }

    public int getDano() {
        return dano;
    }
}
