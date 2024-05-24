package es.uah.metod.practica4ines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoBasicoTest {

    @Test
    void moveIB() {
        IndividuoBasico individuoBasico = new IndividuoBasico(1,2,3,4,5,6,7);
        assertDoesNotThrow(()->individuoBasico.moveIB(1,2));
    }

    @Test
    void testToString() {
        IndividuoBasico individuoBasico = new IndividuoBasico(1,2,3,4,5,6,7);
        assertEquals("IB", individuoBasico.toString());
    }
}