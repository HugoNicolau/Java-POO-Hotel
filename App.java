import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        // Criar um hóspede
        Hospede hospede = new Hospede("João Silva", "123.456.789-00", "11999999999", "joao@email.com");

        // Criar um quarto
        Quarto quartoSimples = new QuartoSimples(101, 2, 150.0, "Casal");

        // Criar datas de entrada e saída
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.APRIL, 10);
        Date dataEntrada = cal.getTime();
        cal.set(2025, Calendar.APRIL, 13);
        Date dataSaida = cal.getTime();

        // Criar uma reserva
        Reserva reserva = new Reserva(hospede, quartoSimples, dataEntrada, dataSaida);

        // Adicionar serviços à reserva
        Servico cafeDaManha = new Servico("Café da manhã", 20.0, true);
        Servico estacionamento = new Servico("Estacionamento", 30.0, false);
        reserva.adicionarServico(cafeDaManha);
        reserva.adicionarServico(estacionamento);

        // Criar serviço avulso (fora da reserva)
        Servico lavanderia = new Servico("Lavanderia", 50.0, false);

        // Criar a fatura e adicionar itens cobraveis
        Fatura fatura = new Fatura(hospede.getNome());
        fatura.adicionarItem(reserva); // Reserva é cobravel
        fatura.adicionarItem(lavanderia); // Serviço avulso também é cobravel

        // Imprimir a fatura
        fatura.imprimirFatura();
    }
}
