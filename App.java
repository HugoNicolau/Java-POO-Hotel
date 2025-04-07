import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        // Criar o hotel
        Hotel hotel = new Hotel("Hotel Estrela");

        // Criar e cadastrar hóspedes
        Hospede joao = new Hospede("João Silva", "123.456.789-00", "11999999999", "joao@email.com");
        Hospede maria = new Hospede("Maria Souza", "987.654.321-00", "11988888888", "maria@email.com");
        hotel.cadastrarHospede(joao);
        hotel.cadastrarHospede(maria);

        // Criar e cadastrar quartos
        Quarto quartoSimples = new QuartoSimples(101, 2, 150.0, "Casal");
        Quarto quartoLuxo = new QuartoLuxo(201, 2, 300.0, "King", true, true, true);
        hotel.cadastrarQuarto(quartoSimples);
        hotel.cadastrarQuarto(quartoLuxo);

        // Criar datas
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.APRIL, 10);
        Date entrada1 = cal.getTime();
        cal.set(2025, Calendar.APRIL, 13);
        Date saida1 = cal.getTime();

        cal.set(2025, Calendar.APRIL, 15);
        Date entrada2 = cal.getTime();
        cal.set(2025, Calendar.APRIL, 18);
        Date saida2 = cal.getTime();

        // Fazer reservas
        Reserva reservaJoao = hotel.fazerReserva(joao, quartoSimples, entrada1, saida1);
        Reserva reservaMaria = hotel.fazerReserva(maria, quartoLuxo, entrada2, saida2);

        // Criar e adicionar serviços
        Servico cafe = new Servico("Café da manhã", 20.0, true);
        Servico estacionamento = new Servico("Estacionamento", 30.0, false);
        Servico spa = new Servico("Spa", 100.0, false);

        reservaJoao.adicionarServico(cafe);
        reservaJoao.adicionarServico(estacionamento);

        reservaMaria.adicionarServico(cafe);
        reservaMaria.adicionarServico(spa);

        // Criar faturas
        Fatura faturaJoao = new Fatura(joao.getNome());
        faturaJoao.adicionarItem(reservaJoao);
        faturaJoao.adicionarItem(new Servico("Lavanderia", 50.0, false)); // avulso

        Fatura faturaMaria = new Fatura(maria.getNome());
        faturaMaria.adicionarItem(reservaMaria);

        // Imprimir faturas
        System.out.println("\n--- Fatura João ---");
        faturaJoao.imprimirFatura();

        System.out.println("\n--- Fatura Maria ---");
        faturaMaria.imprimirFatura();
    }
}
