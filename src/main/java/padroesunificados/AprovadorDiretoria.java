package padroesunificados;

public class AprovadorDiretoria extends Aprovador {

    public AprovadorDiretoria(Aprovador superior) {
        setAprovadorSuperior(superior);
    }

    public double getLimiteAlcada() {
        return 1000000.0;
    }

    public String getDescricaoCargo() {
        return "Diretoria";
    }

}
