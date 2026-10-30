package padroesunificados;

public class AprovadorGerente extends Aprovador {

    public AprovadorGerente(Aprovador superior) {
        setAprovadorSuperior(superior);
    }

    public double getLimiteAlcada() {
        return 50000.0;
    }

    public String getDescricaoCargo() {
        return "Gerente de Agência";
    }

}
