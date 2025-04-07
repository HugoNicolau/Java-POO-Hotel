import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//  * Classe Reserva - Demonstra:
//  * 1. IMPLEMENTAÇÃO DE INTERFACE: Implementa Cobravel
//  * 2. COMPOSIÇÃO: Contém referências a Hospede, Quarto e lista de Servicos
//  * 3. ENCAPSULAMENTO: Atributos privados com acesso controlado
//  * 4. COESÃO: Classe com responsabilidade específica (gerenciar reserva)
//  * 5. USO DE COLEÇÕES: ArrayList para gerenciar múltiplos serviços
//  * 6. ATRIBUTO DE CLASSE (STATIC): Contador de IDs para garantir unicidade

public class Reserva implements Cobravel {
    private static int contadorIds = 1;

    private final int id;
    private Hospede hospede;
    private Quarto quarto;
    private Date dataEntrada;
    private Date dataSaida;
    private final List<Servico> servicos;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
        int dias = (int) (diff / (1000 * 60 * 60 * 24));
        return dias == 0 ? 1 : dias; // considera mínimo de 1 diária
    }

    public double calcularValorServicos() {
        double total = 0;
        for (Servico servico : servicos) {
            total += servico.isPorPessoa() ? servico.getPreco() * quarto.getCapacidade() : servico.getPreco();
        }
        return total;
    }

    public double calcularValorTotal() {
        return quarto.getPrecoPorNoite() * getNumeroDias() + calcularValorServicos();
    }

    @Override
    public double calcularValor() {
        return calcularValorTotal();
    }

    @Override
    public String toString() {
        StringBuilder servicosFormatados = new StringBuilder();
        for (Servico s : servicos) {
            servicosFormatados.append("- ").append(s).append("\n");
        }

        String servicosTexto = servicos.isEmpty()
                ? "Nenhum serviço adicionado."
                : servicos.stream().map(s -> "- " + s).reduce("", (a, b) -> a + b + "\n").trim();

        return "Reserva #" + id +
                "\nHóspede: " + hospede.getNome() +
                "\nQuarto: " + quarto.getDescricao() +
                "\nEntrada: " + sdf.format(dataEntrada) +
                "\nSaída: " + sdf.format(dataSaida) +
                "\nServiços:\n" + servicosTexto +
                "\nValor Total: R$" + String.format("%.2f", calcularValor());
    }
}
