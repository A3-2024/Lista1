public class Item {
    private String jogos;
    private String categoria;
    private double avaliacao;

    public Item(String jogos, String categoria, double avaliacao) {
        this.jogos = jogos;
        this.categoria = categoria;
        this.avaliacao = avaliacao;
    }

    public String getJogos() {
        return jogos;
    }

    public void setJogos(String jogos) {
        this.jogos = jogos;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return "| Jogo:" + jogos + "| Categoria:" +  categoria + "| Avaliação:" +  avaliacao + " |";

    }




}
