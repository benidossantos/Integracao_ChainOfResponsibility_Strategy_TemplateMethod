package padroesunificados;

public abstract class Aprovador {

    private Aprovador aprovadorSuperior;

    public Aprovador getAprovadorSuperior() {
        return aprovadorSuperior;
    }

    public void setAprovadorSuperior(Aprovador aprovadorSuperior) {
        this.aprovadorSuperior = aprovadorSuperior;
    }

    public abstract double getLimiteAlcada();

    public abstract String getDescricaoCargo();

    public String aprovar(Emprestimo emprestimo) {
        if (emprestimo.calcularValorTotal() <= getLimiteAlcada()) {
            return getDescricaoCargo();
        }
        else {
            if (aprovadorSuperior != null) {
                return aprovadorSuperior.aprovar(emprestimo);
            }
            else {
                return "Proposta recusada";
            }
        }
    }
}
