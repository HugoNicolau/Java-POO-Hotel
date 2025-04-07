//  * Classe abstrata Pessoa - Demonstra:
//  * 1. ABSTRAÇÃO: Representa o conceito genérico de uma pessoa no sistema
//  * 2. ENCAPSULAMENTO: Atributos privados com getters/setters
//  * 3. MÉTODOS ABSTRATOS: exibirInformacoes() para implementação obrigatória nas subclasses
//  * 4. COMPOSIÇÃO DE COMPORTAMENTO: Método toString() fornece representação padrão

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;

    public Pessoa(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Metodo abstrato para ser implementado nas subclasses
    public abstract void exibirInformacoes();

    @Override
    public String toString() {
        return nome + " | CPF: " + cpf + " | Tel: " + telefone;
    }

}