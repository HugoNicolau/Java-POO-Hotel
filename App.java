import java.util.Calendar;
import java.util.Date;

//  * Classe App - Demonstra:
//  * 1. CLIENTE DO SISTEMA: Utiliza as classes do domínio para compor uma aplicação
//  * 2. INSTANCIAÇÃO DE OBJETOS: Cria e conecta objetos do domínio
//  * 3. COMPOSIÇÃO DE COMPORTAMENTOS: Orquestra diferentes componentes do sistema
//  * 4. PROGRAMAÇÃO PARA INTERFACES: Utiliza abstrações ao invés de implementações específicas
//  * 5. MÉTODOS UTILITÁRIOS: Como criarData() para encapsular funcionalidade reutilizável

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

        // Criar datas para as reservas
        Date entrada1 = criarData(2025, Calendar.APRIL, 10);
        Date saida1 = criarData(2025, Calendar.APRIL, 13);

        Date entrada2 = criarData(2025, Calendar.APRIL, 15);
        Date saida2 = criarData(2025, Calendar.APRIL, 18);

        // Fazer reservas
        Reserva reservaJoao = hotel.fazerReserva(joao, quartoSimples, entrada1, saida1);
        Reserva reservaMaria = hotel.fazerReserva(maria, quartoLuxo, entrada2, saida2);

        // Criar e adicionar serviços
        Servico cafe = new Servico("Café da manhã", 20.0, true);
        Servico estacionamento = new Servico("Estacionamento", 30.0, false);
        Servico spa = new Servico("Spa", 100.0, false);
        Servico lavanderia = new Servico("Lavanderia", 50.0, false);

        reservaJoao.adicionarServico(cafe);
        reservaJoao.adicionarServico(estacionamento);

        reservaMaria.adicionarServico(cafe);
        reservaMaria.adicionarServico(spa);

        // Criar faturas
        Fatura faturaJoao = new Fatura(joao.getNome());
        faturaJoao.adicionarItem(reservaJoao);
        faturaJoao.adicionarItem(lavanderia); // serviço avulso

        Fatura faturaMaria = new Fatura(maria.getNome());
        faturaMaria.adicionarItem(reservaMaria);

        // Imprimir faturas
        System.out.println("\n--- Fatura João ---");
        faturaJoao.imprimirFatura();

        System.out.println("\n--- Fatura Maria ---");
        faturaMaria.imprimirFatura();
    }

    private static Date criarData(int ano, int mes, int dia) {
        Calendar cal = Calendar.getInstance();
        cal.set(ano, mes, dia, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
