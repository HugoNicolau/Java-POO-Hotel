//  * Classe abstrata Quarto - Demonstra:
//  * 1. ABSTRAÇÃO: Modelo genérico para todos os tipos de quartos
//  * 2. ENCAPSULAMENTO: Atributos privados com acesso controlado
//  * 3. MÉTODOS ABSTRATOS: getDescricao() deve ser implementado pelas subclasses
//  * 4. POLIMORFISMO: Diferentes implementações nos subtipos (QuartoSimples/QuartoLuxo)

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
