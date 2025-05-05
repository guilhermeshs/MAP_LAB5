package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

class FilmeTest {

    private Filme filme;

    @BeforeEach
    void setUp() {
        filme = new Filme("Interestelar", 2014);
    }

    @Test
    void testAdicionarNoFilme() {
        boolean adicionado = filme.adicionarNoFilme("111", "João", "Roteirista");
        assertTrue(adicionado);

        Map<String, Map<String, java.util.List<String>>> funcionarios = filme.getFuncionarios();
        assertTrue(funcionarios.containsKey("111"));
        assertTrue(funcionarios.get("111").get("João").contains("Roteirista"));
    }

    @Test
    void testAtualizarFuncoes() {
        filme.adicionarNoFilme("222", "Ana", "Atriz");
        filme.atualizarFuncoes("222", "Ana", "Produtora");

        assertTrue(filme.getFuncionarios().get("222").get("Ana").contains("Produtora"));
    }

    @Test
    void testSetTrilhaSonora() {
        filme.setTrilhaSonora("Hans Zimmer");
        String output = filme.toString();
        assertTrue(output.contains("Hans Zimmer"));
    }

    @Test
    void testToString() {
        filme.adicionarNoFilme("123", "Carlos", "Editor");
        String out = filme.toString();
        assertTrue(out.contains("Carlos"));
        assertTrue(out.contains("Editor"));
    }
}
