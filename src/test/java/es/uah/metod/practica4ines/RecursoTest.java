package es.uah.metod.practica4ines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoTest {

    @Test
    void getId() {
        Recurso recurso = new Recurso(1, "Mont", 2);
        assertEquals(1, recurso.getId());
    }

    @Test
    void getTipo() {
        Recurso recurso = new Recurso(1, "Mont", 2);
        assertEquals("Mont", recurso.getTipo());
    }

    @Test
    void getTiempoAparicion() {
        Recurso recurso = new Recurso(1, "Mont", 2);
        assertEquals(2, recurso.getTiempoAparicion());
    }


    @Test
    void actualizar() {
        Recurso recurso = new Recurso(1, "Mont", 2);
        assertDoesNotThrow(()->recurso.actualizar());
        assertEquals(1, recurso.getTiempoAparicion());
    }

    @Test
    void testToString() {
        Recurso recurso = new Recurso(1, "Mont", 2);
        assertEquals("RMont", recurso.toString());
    }
}