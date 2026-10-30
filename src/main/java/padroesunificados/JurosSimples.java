package padroesunificados;

public class JurosSimples implements CalculoJuros {

    public double calcular(double valor, double taxaMensal, int meses) {
        return valor * (1 + taxaMensal * meses);
    }
}
