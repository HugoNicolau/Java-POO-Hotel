public class QuartoSimples extends Quarto {
    private String tipoCama;

    public QuartoSimples(int numero, int capacidade, double precoPorNoite, String tipoCama) {
        super(numero, capacidade, precoPorNoite);
        this.tipoCama = tipoCama;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }

    @Override
    public String getDescricao() {
        return "Quarto Simples: " + numero + ", Capacidade: " + capacidade + ", Preço por Noite: " + precoPorNoite + ", Tipo de Cama: " + tipoCama;
    }
    
}
