package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoteiristaTest {

    @Test
    void testGetDescricao() {
        Funcao roteirista = new Roteirista();
        assertEquals("Roteirista", roteirista.getDescricao());
    }
}
