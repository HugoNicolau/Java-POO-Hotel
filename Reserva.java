import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva implements Cobravel {
    private static int contadorIds = 1; // atributo estático para gerar IDs únicos

    private final int id;
    private Hospede hospede; // associação com a classe Hospede
    private Quarto quarto; // associação com a classe Quarto
    private Date dataEntrada;
    private Date dataSaida;
    private final List<Servico> servicos; // composição: lista de serviços incluídos

    public Reserva(Hospede hospede, Quarto quarto, Date dataEntrada, Date dataSaida) {
        if (dataSaida.before(dataEntrada)) {
            throw new IllegalArgumentException("Data de saída não pode ser antes da data de entrada.");
        }
        this.id = contadorIds++;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.servicos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void adicionarServico(Servico servico) {
        this.servicos.add(servico);
    }

    public void removerServico(Servico servico) {
        this.servicos.remove(servico);
    }

    public int getNumeroDias() {
        long diff = dataSaida.getTime() - dataEntrada.getTime();
        return (int) (diff / (1000 * 60 * 60 * 24));
    }

    public double calcularValorTotal() {
        int dias = getNumeroDias();
        double total = quarto.getPrecoPorNoite() * dias;

        for (Servico servico : servicos) {
            total += servico.isPorPessoa() ? servico.getPreco() * quarto.getCapacidade() : servico.getPreco();
        }

        return total;
    }

    @Override
    public double calcularValor() {
        return calcularValorTotal();
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public String toString() {
        return "Reserva #" + id +
                "\nHóspede: " + hospede.getNome() +
                "\nQuarto: " + quarto.getDescricao() +
                "\nEntrada: " + sdf.format(dataEntrada) +
                "\nSaída: " + sdf.format(dataSaida) +
                "\nServiços: " + servicos +
                "\nValor Total: R$" + String.format("%.2f", calcularValorTotal());
    }

}
