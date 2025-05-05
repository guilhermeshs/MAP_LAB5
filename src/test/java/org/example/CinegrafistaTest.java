package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CinegrafistaTest {

    @Test
    void testGetDescricao() {
        Funcao cinegrafista = new Cinegrafista();
        assertEquals("Cinegrafista", cinegrafista.getDescricao());
    }
}
