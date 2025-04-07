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
    
}
