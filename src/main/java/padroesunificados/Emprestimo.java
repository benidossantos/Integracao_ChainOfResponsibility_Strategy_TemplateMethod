package padroesunificados;

import java.util.Locale;

public abstract class Emprestimo {

    private double valor;
    private int meses;
    private CalculoJuros calculoJuros;

    public Emprestimo(double valor, int meses, CalculoJuros calculoJuros) {
        this.valor = valor;
        this.meses = meses;
        this.calculoJuros = calculoJuros;
    }

    public double getValor() {
        return valor;
    }

    public int getMeses() {
        return meses;
    }

    public CalculoJuros getCalculoJuros() {
        return calculoJuros;
    }

    public void setCalculoJuros(CalculoJuros calculoJuros) {
        this.calculoJuros = calculoJuros;
    }

    public abstract double getTaxaMensal();

    public abstract double getTarifa();

    public abstract String getTipo();

    public double calcularValorTotal() {
        return calculoJuros.calcular(valor, getTaxaMensal(), meses) + getTarifa();
    }

    public final String processar(Aprovador aprovador) {
        if (valor <= 0 || meses <= 0) {
            throw new IllegalArgumentException("Valor e prazo devem ser positivos");
        }
        return getTipo() + "{" +
                "valor=" + String.format(Locale.ROOT, "%.2f", valor) +
                ", meses=" + meses +
                ", total=" + String.format(Locale.ROOT, "%.2f", calcularValorTotal()) +
                ", aprovacao=" + aprovador.aprovar(this) +
                '}';
    }
}
