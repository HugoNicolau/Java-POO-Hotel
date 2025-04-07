//  * Classe QuartoSimples - Demonstra:
//  * 1. HERANÇA: Implementação concreta da classe abstrata Quarto
//  * 2. ESPECIALIZAÇÃO: Adiciona atributos e comportamentos específicos
//  * 3. POLIMORFISMO: Implementa getDescricao() de forma específica
//  * 4. SOBRESCRITA: Implementa toString() com detalhes específicos deste tipo

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
        return "Quarto Simples " + numero + " - " + capacidade + " pessoa(s), Cama: " + tipoCama;
    }

    @Override
    public String toString() {
        return "Quarto Simples #" + numero +
                "\nCapacidade: " + capacidade +
                "\nTipo de Cama: " + tipoCama +
                "\nPreço por Noite: R$" + String.format("%.2f", precoPorNoite);
    }
}
