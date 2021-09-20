package servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.servicos.LocacaoService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocacaoServiceTest {

//    @Rule
//    public ErrorCollector errorCollector = new ErrorCollector();
//
//    @Rule
//    public ExpectedException expectedException = ExpectedException.none();

    /**
     * Faça antes do primeiro metodo
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll");
    }

    /**
     * Antes de cada metodo faça
     */
    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach");
    }

    /**
     * Depois de cada metodo faça
     */
    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    /**
     * Faça depois do ultimo metodo
     */
    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }

    @Test
    void testeSimples() throws Exception {
        // Cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 2, 5.0);

        // Acao
        Locacao locacao = service.alugarFilme(usuario, filme);

        // Verificacao
        assertEquals(5.0, locacao.getValor());
        assertNotEquals(7, locacao.getValor());

        System.out.println("testeSimples");
    }

    @Test
    void testeExcecaoSemEstoque() {
        // Cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 0, 5.0);

        // Acao e Resultado com lançamento de exceção esperada
        Assertions.assertThrows(Exception.class, () -> {
            Locacao locacao = service.alugarFilme(usuario, filme);
        });
        System.out.println("testeExcecaoSemEstoque");
    }

    /**
     * Metodo responsavel por verificar se a execação está lançado
     * Para filme sem estoque
     */
    @Test
    void testeVerificarExcecao() {
        // Cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 0, 5.0);

        // Acao
        FilmeSemEstoqueException filmeSemEstoqueException = assertThrows(FilmeSemEstoqueException.class, () -> {
            service.alugarFilme(usuario, filme);
        });

        // Verificacao
        assertTrue(filmeSemEstoqueException.getMessage().contains("Filme sem estoque"));

        System.out.println("testeVerificarExcecao");
    }

    /**
     * Teste responsavel por verifiar se a locacao contem Usuario ou filme com campos vazios
     */
    @Test
    void testeLocacaoVazia() {
        // Cenario
        LocacaoService service = new LocacaoService();
        Filme filme = new Filme("Filme 2", 2, 4.0);

        // Acao
        LocadoraException locadoraException = assertThrows(LocadoraException.class, () -> {
            service.alugarFilme(null, filme);
        });
        Assertions.assertEquals(locadoraException.getMessage(), "Usuario ou Filme não preenchidos");
        System.out.println("testeLocacaoVazia");

    }
}
