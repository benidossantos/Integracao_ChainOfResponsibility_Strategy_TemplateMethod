package padroesunificados;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoTest {

    Aprovador aprovador;

    @BeforeEach
    void setUp() {
        AprovadorDiretoria diretoria = new AprovadorDiretoria(null);
        AprovadorSuperintendente superintendente = new AprovadorSuperintendente(diretoria);
        AprovadorGerente gerente = new AprovadorGerente(superintendente);
        aprovador = new AprovadorAnalista(gerente);
    }

    // Strategy

    @Test
    void deveCalcularJurosSimples() {
        Emprestimo emprestimo = new EmprestimoConsignado(5000.0, 10, new JurosSimples());
        assertEquals(6000.0, emprestimo.calcularValorTotal(), 0.01);
    }

    @Test
    void deveCalcularJurosCompostos() {
        Emprestimo emprestimo = new EmprestimoPessoal(1000.0, 2, new JurosCompostos());
        assertEquals(1202.5, emprestimo.calcularValorTotal(), 0.01);
    }

    @Test
    void deveCalcularTabelaPrice() {
        Emprestimo emprestimo = new EmprestimoConsignado(10000.0, 12, new TabelaPrice());
        assertEquals(11347.15, emprestimo.calcularValorTotal(), 0.01);
    }

    @Test
    void deveTrocarEstrategiaDeJuros() {
        Emprestimo emprestimo = new EmprestimoPessoal(1000.0, 2, new JurosSimples());
        assertEquals(1200.0, emprestimo.calcularValorTotal(), 0.01);
        emprestimo.setCalculoJuros(new JurosCompostos());
        assertEquals(1202.5, emprestimo.calcularValorTotal(), 0.01);
    }

    // Chain of Responsibility

    @Test
    void deveSerAprovadoPeloAnalista() {
        Emprestimo emprestimo = new EmprestimoConsignado(5000.0, 10, new JurosSimples());
        assertEquals("Analista de Crédito", aprovador.aprovar(emprestimo));
    }

    @Test
    void deveSerAprovadoPeloGerente() {
        Emprestimo emprestimo = new EmprestimoPessoal(20000.0, 12, new JurosSimples());
        assertEquals("Gerente de Agência", aprovador.aprovar(emprestimo));
    }

    @Test
    void deveSerAprovadoPeloSuperintendente() {
        Emprestimo emprestimo = new FinanciamentoImobiliario(150000.0, 12, new JurosSimples());
        assertEquals("Superintendente Regional", aprovador.aprovar(emprestimo));
    }

    @Test
    void deveSerAprovadoPelaDiretoria() {
        Emprestimo emprestimo = new FinanciamentoImobiliario(500000.0, 60, new JurosSimples());
        assertEquals("Diretoria", aprovador.aprovar(emprestimo));
    }

    @Test
    void deveSerRecusado() {
        Emprestimo emprestimo = new FinanciamentoImobiliario(900000.0, 120, new JurosSimples());
        assertEquals("Proposta recusada", aprovador.aprovar(emprestimo));
    }

    // Template Method

    @Test
    void deveProcessarEmprestimoConsignado() {
        Emprestimo emprestimo = new EmprestimoConsignado(5000.0, 10, new JurosSimples());
        assertEquals("EmprestimoConsignado{valor=5000.00, meses=10, total=6000.00, aprovacao=Analista de Crédito}",
                emprestimo.processar(aprovador));
    }

    @Test
    void deveProcessarEmprestimoPessoal() {
        Emprestimo emprestimo = new EmprestimoPessoal(20000.0, 12, new JurosSimples());
        assertEquals("EmprestimoPessoal{valor=20000.00, meses=12, total=32100.00, aprovacao=Gerente de Agência}",
                emprestimo.processar(aprovador));
    }

    @Test
    void deveProcessarFinanciamentoImobiliario() {
        Emprestimo emprestimo = new FinanciamentoImobiliario(150000.0, 12, new JurosSimples());
        assertEquals("FinanciamentoImobiliario{valor=150000.00, meses=12, total=171000.00, aprovacao=Superintendente Regional}",
                emprestimo.processar(aprovador));
    }

    @Test
    void naoDeveProcessarEmprestimoComPrazoInvalido() {
        try {
            Emprestimo emprestimo = new EmprestimoPessoal(1000.0, 0, new JurosSimples());
            emprestimo.processar(aprovador);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor e prazo devem ser positivos", e.getMessage());
        }
    }
}
