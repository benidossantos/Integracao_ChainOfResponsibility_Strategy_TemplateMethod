package padroesunificados;

public class AprovadorSuperintendente extends Aprovador {

    public AprovadorSuperintendente(Aprovador superior) {
        setAprovadorSuperior(superior);
    }

    public double getLimiteAlcada() {
        return 200000.0;
    }

    public String getDescricaoCargo() {
        return "Superintendente Regional";
    }

}
