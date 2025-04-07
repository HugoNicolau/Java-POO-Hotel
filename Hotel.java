import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//  * Classe Hotel - Demonstra:
//  * 1. AGREGAÇÃO: Contém listas de Hospedes, Quartos e Reservas
//  * 2. FACADE: Fornece interface simplificada para operações complexas do sistema
//  * 3. ALTO NÍVEL DE ABSTRAÇÃO: Trabalha com objetos de domínio de alto nível
//  * 4. USO DE COLEÇÕES: ArrayList para gerenciar múltiplas entidades
//  * 5. ENCAPSULAMENTO: Acesso controlado às coleções internas
//  * 6. BAIXO ACOPLAMENTO: Depende de abstrações, não implementações

public class Hotel {
    private String nome;
    private List<Hospede> hospedes;
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel(String nome) {
        this.nome = nome;
        this.hospedes = new ArrayList<>();
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void cadastrarHospede(Hospede hospede) {
        hospedes.add(hospede);
    }

    public void cadastrarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public List<Hospede> getHospedes() {
        return List.copyOf(hospedes);
    }

    public List<Quarto> getQuartos() {
        return List.copyOf(quartos);
    }

    public List<Reserva> getReservas() {
        return List.copyOf(reservas);
    }

    public void listarHospedes() {
        System.out.println("=== Lista de Hóspedes ===\n");
        int i = 1;
        for (Hospede h : hospedes) {
            System.out.println("Hóspede " + i + ":");
            h.exibirInformacoes();
            i++;
        }
    }

    public void listarQuartos() {
        System.out.println("=== Quartos Disponíveis ===\n");
        int i = 1;
        for (Quarto q : quartos) {
            System.out.println("Quarto " + i + ":\n" + q);
            System.out.println("-----------------------------");
            i++;
        }
    }

    public void listarReservas() {
        System.out.println("=== Reservas Realizadas ===\n");
        int i = 1;
        for (Reserva r : reservas) {
            System.out.println("Reserva " + i + ":\n" + r);
            System.out.println("------------------------------");
            i++;
        }
    }

    public boolean quartoDisponivel(Quarto quarto, Date entrada, Date saida) {
        for (Reserva r : reservas) {
            if (r.getQuarto().equals(quarto) &&
                    !(saida.before(r.getDataEntrada()) || entrada.after(r.getDataSaida()))) {
                return false; // sobreposição de datas
            }
        }
        return true;
    }

    public Reserva fazerReserva(Hospede hospede, Quarto quarto, Date entrada, Date saida) {
        if (!quartoDisponivel(quarto, entrada, saida)) {
            throw new IllegalArgumentException("Quarto já reservado nesse período.");
        }
        Reserva reserva = new Reserva(hospede, quarto, entrada, saida);
        reservas.add(reserva);
        return reserva;
    }

    public void cancelarReserva(int idReserva) {
        reservas.removeIf(reserva -> reserva.getId() == idReserva);
    }

    public Optional<Quarto> buscarQuartoPorNumero(int numero) {
        return quartos.stream().filter(q -> q.getNumero() == numero).findFirst();
    }

    public Optional<Hospede> buscarHospedePorCPF(String cpf) {
        return hospedes.stream().filter(h -> h.getCpf().equals(cpf)).findFirst();
    }

    public String getNome() {
        return nome;
    }
}
