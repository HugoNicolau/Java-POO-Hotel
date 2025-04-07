public abstract class Quarto {
    protected int numero;
    protected int capacidade;
    protected double precoPorNoite;
    protected boolean ocupado;

    public Quarto(int numero, int capacidade, double precoPorNoite) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.precoPorNoite = precoPorNoite;
        this.ocupado = false;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar() {
        this.ocupado = true;
    }

    public void liberar() {
        this.ocupado = false;
    }

    // Método abstrato

    public abstract String getDescricao();

}
