//  * Classe QuartoLuxo - Demonstra:
//  * 1. HERANÇA: Implementação concreta da classe abstrata Quarto
//  * 2. ESPECIALIZAÇÃO: Adiciona atributos e comportamentos específicos para quartos de luxo
//  * 3. POLIMORFISMO DE SOBRESCRITA: Implementa getDescricao() de forma específica para este tipo
//  * 4. ENCAPSULAMENTO: Atributos privados com getters/setters controlando acesso
//  * 5. CONSTRUTORES ENCADEADOS: Usa super() para inicializar atributos da superclasse
//  * 6. SOBRESCRITA: Implementa toString() com representação textual específica deste tipo

public class QuartoLuxo extends Quarto {
    private String tipoCama;
    private boolean possuiJacuzzi;
    private boolean incluiCafeDaManha;
    private boolean possuiVaranda;

    /**
     * Construtor que inicializa todos os atributos e chama o construtor da superclasse
     * Demonstra o reuso de código através do uso de super()
     */
    public QuartoLuxo(int numero, int capacidade, double precoPorNoite, String tipoCama,
                      boolean possuiJacuzzi, boolean incluiCafeDaManha, boolean possuiVaranda) {
        super(numero, capacidade, precoPorNoite);
        this.tipoCama = tipoCama;
        this.possuiJacuzzi = possuiJacuzzi;
        this.incluiCafeDaManha = incluiCafeDaManha;
        this.possuiVaranda = possuiVaranda;
    }

    // Métodos de acesso - exemplos de encapsulamento
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

    /**
     * Implementação do método abstrato da superclasse - POLIMORFISMO
     * Cada tipo de quarto pode fornecer sua própria descrição
     */
    @Override
    public String getDescricao() {
        return "Quarto Luxo " + numero + " - " + capacidade + " pessoa(s), Cama: " + tipoCama;
    }

    /**
     * Sobrescrita do método toString() da classe Object - POLIMORFISMO
     * Fornece uma representação textual mais detalhada específica para quartos de luxo
     */
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
