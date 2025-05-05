package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ControleDeAcessoTest {

    private ControleDeAcesso controle;
    private Funcao funcaoMock;

    @BeforeEach
    void setUp() {
        controle = new ControleDeAcesso();
        funcaoMock = () -> "Fotógrafo";
    }

    @Test
    void testCadastrarFuncionario() {
        Funcionario f = controle.cadastrarFuncionario("Pedro", "999");
        assertNotNull(f);
        assertEquals("Pedro", f.getNome());
    }

    @Test
    void testCadastrarFilme() {
        Filme filme = controle.cadastrarFilme("Matrix", 1999);
        assertNotNull(filme);
        assertEquals("Matrix", filme.getNome());
    }

    @Test
    void testAdicionarAoFilme() {
        controle.cadastrarFilme("Matrix", 1999);
        controle.cadastrarFuncionario("Pedro", "999");

        controle.adicionarAoFilme("Matrix", "999", funcaoMock);

        Filme filme = controle.getFilme("Matrix");
        assertTrue(filme.getFuncionarios().containsKey("999"));

        Funcionario funcionario = controle.getFuncionario("999");
        assertTrue(funcionario.getFilmografia().containsKey("Matrix"));
    }

    @Test
    void testAtualizarFuncaoEmFilme() {
        controle.cadastrarFilme("Matrix", 1999);
        controle.cadastrarFuncionario("Pedro", "999");

        controle.adicionarAoFilme("Matrix", "999", funcaoMock);

        Funcao novaFuncao = () -> "Produtor";
        controle.atualizarFuncaoEmFilme("Matrix", "999", novaFuncao);

        Funcionario funcionario = controle.getFuncionario("999");
        assertTrue(funcionario.getFuncoes().contains(novaFuncao));
    }
}
