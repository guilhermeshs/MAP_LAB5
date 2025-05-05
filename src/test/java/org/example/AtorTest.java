package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AtorTest {

    @Test
    void testGetDescricao() {
        Funcao ator = new Ator();
        assertEquals("Ator", ator.getDescricao());
    }
}
