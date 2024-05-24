package es.uah.metod.practica4ines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoAvanzadoTest {

    @Test
    void moveIA() {
        IndividuoAvanzado individuoAvanzado = new IndividuoAvanzado(1,2,3,4,5,6,7);
        assertDoesNotThrow(()-> individuoAvanzado.moveIA(1,2));
    }

    @Test
    void testToString() {
        IndividuoAvanzado individuoAvanzado = new IndividuoAvanzado(1,2,3,4,5,6,7);
        assertEquals("IA", individuoAvanzado.toString());
    }
}