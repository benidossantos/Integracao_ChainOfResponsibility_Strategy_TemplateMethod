package padroesunificados;

public class AprovadorAnalista extends Aprovador {

    public AprovadorAnalista(Aprovador superior) {
        setAprovadorSuperior(superior);
    }

    public double getLimiteAlcada() {
        return 10000.0;
    }

    public String getDescricaoCargo() {
        return "Analista de Crédito";
    }

}
