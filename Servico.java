public class Servico implements Cobravel {
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

    public double getPreco() {
        return preco;
    }

    public boolean isPorPessoa() {
        return porPessoa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setPorPessoa(boolean porPessoa) {
        this.porPessoa = porPessoa;
    }

    @Override
    public double calcularValor() {
        return preco; // usado quando o serviço é cobrado avulso, fora da reserva
    }

    @Override
    public String toString() {
        return nome + " - R$" + String.format("%.2f", preco) +
                (porPessoa ? " (por pessoa)" : "");
    }
}
