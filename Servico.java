public class Servico {
    private String nome;
    private double preco;
    private boolean porPessoa;

    public Servico(String nome, double preco, boolean porPessoa) {
        this.nome = nome;
        this.preco = preco;
        this.porPessoa = porPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isPorPessoa() {
        return porPessoa;
    }

    public void setPorPessoa(boolean porPessoa) {
        this.porPessoa = porPessoa;
    }

    @Override
    public String toString() {
        return nome + " (R$ " + String.format("%.2f", preco) +
                (porPessoa ? " por pessoa" : " fixo") + ")";
    }

}
