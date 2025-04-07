//  * Classe Hospede - Demonstra:
//  * 1. HERANÇA: Estende a classe abstrata Pessoa
//  * 2. POLIMORFISMO DE SOBRESCRITA: Implementa exibirInformacoes() da superclasse
//  * 3. ENCAPSULAMENTO: Atributo email privado com getter/setter
//  * 4. CONSTRUTORES ENCADEADOS: Usa super() para chamar construtor da classe pai
//  * 5. POLIMORFISMO DE SOBRESCRITA: Sobrescreve toString() para representação específica

public class Hospede extends Pessoa {
    private String email;

    public Hospede(String nome, String cpf, String telefone, String email) {
        super(nome, cpf, telefone);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Sobrescrevendo o método abstrato da classe Pessoa
    @Override
    public void exibirInformacoes() {
        System.out.println("Hóspede:");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Email: " + getEmail());
        System.out.println("------------------------------");
    }

    @Override
    public String toString() {
        return getNome() + " - " + getEmail();
    }

}
