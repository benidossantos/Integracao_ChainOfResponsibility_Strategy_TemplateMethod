package padroesunificados;

public class TabelaPrice implements CalculoJuros {

    public double calcular(double valor, double taxaMensal, int meses) {
        double parcela = valor * taxaMensal / (1 - Math.pow(1 + taxaMensal, -meses));
        return parcela * meses;
    }
}
