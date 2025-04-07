import java.util.ArrayList;
import java.util.List;

//  * Classe Fatura - Demonstra:
//  * 1. COMPOSIÇÃO: Agrega múltiplos itens cobráveis
//  * 2. POLIMORFISMO: Trata diferentes tipos de Cobravel de forma homogênea
//  * 3. PRINCÍPIO ABERTO-FECHADO: Aberta para extensão (novos tipos Cobravel) sem modificação
//  * 4. USO DE COLEÇÕES: Lista para armazenar múltiplos itens
//  * 5. RESPONSABILIDADE ÚNICA: Focada apenas em gerar uma fatura

public class Fatura {
    private List<Cobravel> itens;
    private String titular;

    public Fatura(String titular) {
        this.titular = titular;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Cobravel item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Cobravel item : itens) {
            total += item.calcularValor();
        }
        return total;
    }

    public void imprimirFatura() {
        System.out.println("FATURA - Titular: " + titular);
        System.out.println("---------------------------------");

        // Separar reservas e serviços
        for (Cobravel item : itens) {
            if (item instanceof Reserva) {
                System.out.println(item);
            }
        }
        for (Cobravel item : itens) {
            if (item instanceof Servico) {
                System.out.println(item);
            }
        }

        System.out.println("---------------------------------");
        System.out.printf("TOTAL: R$ %.2f%n", calcularTotal());
    }

}
