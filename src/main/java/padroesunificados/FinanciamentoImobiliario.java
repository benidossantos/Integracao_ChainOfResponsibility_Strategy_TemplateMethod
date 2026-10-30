package padroesunificados;

public class FinanciamentoImobiliario extends Emprestimo {

    public FinanciamentoImobiliario(double valor, int meses, CalculoJuros calculoJuros) {
        super(valor, meses, calculoJuros);
    }

    public double getTaxaMensal() {
        return 0.01;
    }

    public double getTarifa() {
        return 3000.0;
    }

    public String getTipo() {
        return "FinanciamentoImobiliario";
    }
}
