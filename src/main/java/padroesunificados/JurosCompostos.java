package padroesunificados;

public class JurosCompostos implements CalculoJuros {

    public double calcular(double valor, double taxaMensal, int meses) {
        return valor * Math.pow(1 + taxaMensal, meses);
    }
}
