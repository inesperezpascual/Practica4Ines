package es.uah.metod.practica4ines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DireccionTest {

    @Test
    void getId() {
        Direccion direccion = new Direccion(1,2,3);
        assertEquals(1, direccion.getId());
    }

    @Test
    void getColumnaCelda() {
        Direccion direccion = new Direccion(1,2,3);
        assertEquals(2, direccion.getColumnaCelda());
    }

    @Test
    void getFilaCelda() {
        Direccion direccion = new Direccion(1,2,3);
        assertEquals(3, direccion.getFilaCelda());
    }
}