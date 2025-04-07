import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public void listarHospedes() {
        for (Hospede h : hospedes) {
            System.out.println(h);
        }
    }

    public void listarQuartos() {
        for (Quarto q : quartos) {
            System.out.println(q.getDescricao());
        }
    }

    public void listarReservas() {
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }

    public Reserva fazerReserva(Hospede hospede, Quarto quarto, Date entrada, Date saida) {
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
