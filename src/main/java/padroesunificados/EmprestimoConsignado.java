package padroesunificados;

public class EmprestimoConsignado extends Emprestimo {

    public EmprestimoConsignado(double valor, int meses, CalculoJuros calculoJuros) {
        super(valor, meses, calculoJuros);
    }

    public double getTaxaMensal() {
        return 0.02;
    }

    public double getTarifa() {
        return 0.0;
    }

    public String getTipo() {
        return "EmprestimoConsignado";
    }
}
