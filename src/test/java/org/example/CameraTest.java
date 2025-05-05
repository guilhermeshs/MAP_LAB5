package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CameraTest {

    @Test
    void testGetDescricao() {
        Funcao camera = new Camera();
        assertEquals("Camera", camera.getDescricao());
    }
}
