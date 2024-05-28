public class Tesouro {

    private String localizacaoNoLabirinto;
    private int danoPotencial;
    private int pontos;
    private int posicaoX;
    private int posicaoY;

    public Tesouro(String localizacaoNoLabirinto, int danoPotencial, int posicaoX, int posicaoY) {

        this.localizacaoNoLabirinto = localizacaoNoLabirinto;
        this.danoPotencial = danoPotencial;
        this.pontos = 0;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
    }

    public String getLocalizacaoNoLabirinto() {
        return localizacaoNoLabirinto;
    }

    public void setLocalizacaoNoLabirinto(String localizacaoNoLabirinto) {
        this.localizacaoNoLabirinto = localizacaoNoLabirinto;
    }

    public int getDanoPotencial() {
        return danoPotencial;
    }

    public void setDanoPotencial(int danoPotencial) {
        this.danoPotencial = danoPotencial;
    }

    public int getPontos() {
        return pontos;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void exibirInformacoes() {
        System.out.println("Tesouro encontrado em: " + localizacaoNoLabirinto);
        System.out.println("Dano potencial: " + danoPotencial);
    }

}
