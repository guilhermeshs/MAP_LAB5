package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

class FuncionarioTest {

    private Funcionario funcionario;
    private Funcao funcaoMock;

    @BeforeEach
    void setUp() {
        funcionario = new Funcionario("Maria", "123456789");
        funcaoMock = () -> "Diretora";
    }

    @Test
    void testAdicionarFilme() {
        funcionario.adicionarFilme(funcaoMock, "FILME01");

        Map<String, List<Funcao>> filmografia = funcionario.getFilmografia();
        assertTrue(filmografia.containsKey("FILME01"));
        assertTrue(filmografia.get("FILME01").contains(funcaoMock));
        assertTrue(funcionario.getFuncoes().contains(funcaoMock));
    }

    @Test
    void testAdicionarFuncaoJaExistente() {
        funcionario.adicionarFilme(funcaoMock, "FILME01");
        funcionario.adicionarFuncao("FILME01", funcaoMock);

        // A função já estava associada, não deve duplicar
        long count = funcionario.getFuncoes().stream()
                .filter(f -> f.getDescricao().equals("Diretora"))
                .count();
        assertEquals(1, count);
    }

    @Test
    void testToStringFilmografiaNaoVazia() {
        funcionario.adicionarFilme(funcaoMock, "FILME01");
        String output = funcionario.toStringFilmografia();
        assertTrue(output.contains("FILME01"));
        assertTrue(output.contains("Diretora"));
    }

    @Test
    void testToStringFuncionario() {
        funcionario.adicionarFilme(funcaoMock, "FILME01");
        String output = funcionario.toString();
        assertTrue(output.contains("Maria"));
        assertTrue(output.contains("Diretora"));
    }
}
