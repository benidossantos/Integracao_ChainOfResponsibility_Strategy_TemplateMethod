package padroesunificados;

public class EmprestimoPessoal extends Emprestimo {

    public EmprestimoPessoal(double valor, int meses, CalculoJuros calculoJuros) {
        super(valor, meses, calculoJuros);
    }

    public double getTaxaMensal() {
        return 0.05;
    }

    public double getTarifa() {
        return 100.0;
    }

    public String getTipo() {
        return "EmprestimoPessoal";
    }
}
