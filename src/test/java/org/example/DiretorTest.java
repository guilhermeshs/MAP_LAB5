package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiretorTest {

    @Test
    void testGetDescricao() {
        Funcao diretor = new Diretor();
        assertEquals("Diretor", diretor.getDescricao());
    }
}
