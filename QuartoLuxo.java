public class QuartoLuxo extends Quarto {
    private String tipoCama;
    private boolean possuiJacuzzi;
    private boolean incluiCafeDaManha;
    private boolean possuiVaranda;

    public QuartoLuxo(int numero, int capacidade, double precoPorNoite, String tipoCama,
                      boolean possuiJacuzzi, boolean incluiCafeDaManha, boolean possuiVaranda) {
        super(numero, capacidade, precoPorNoite);
        this.tipoCama = tipoCama;
        this.possuiJacuzzi = possuiJacuzzi;
        this.incluiCafeDaManha = incluiCafeDaManha;
        this.possuiVaranda = possuiVaranda;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }

    public boolean isPossuiJacuzzi() {
        return possuiJacuzzi;
    }

    public void setPossuiJacuzzi(boolean possuiJacuzzi) {
        this.possuiJacuzzi = possuiJacuzzi;
    }

    public boolean isIncluiCafeDaManha() {
        return incluiCafeDaManha;
    }

    public void setIncluiCafeDaManha(boolean incluiCafeDaManha) {
        this.incluiCafeDaManha = incluiCafeDaManha;
    }

    public boolean isPossuiVaranda() {
        return possuiVaranda;
    }

    public void setPossuiVaranda(boolean possuiVaranda) {
        this.possuiVaranda = possuiVaranda;
    }

    @Override
    public String getDescricao() {
        return "Quarto Luxo " + numero + " - " + capacidade + " pessoa(s), Cama: " + tipoCama;
    }

    @Override
    public String toString() {
        return "Quarto Luxo #" + numero +
                "\nCapacidade: " + capacidade +
                "\nTipo de Cama: " + tipoCama +
                "\nJacuzzi: " + (possuiJacuzzi ? "Sim" : "Não") +
                "\nCafé da Manhã: " + (incluiCafeDaManha ? "Sim" : "Não") +
                "\nVaranda: " + (possuiVaranda ? "Sim" : "Não") +
                "\nPreço por Noite: R$" + String.format("%.2f", precoPorNoite);
    }
}
