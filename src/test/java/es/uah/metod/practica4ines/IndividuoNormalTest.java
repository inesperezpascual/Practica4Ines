package es.uah.metod.practica4ines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoNormalTest {

    @Test
    void moveIN() {
        IndividuoNormal individuoNormal = new IndividuoNormal(1,2,3,4,5,6,7);
        assertDoesNotThrow(()-> individuoNormal.moveIN());
    }

    @Test
    void testToString() {
        IndividuoNormal individuoNormal = new IndividuoNormal(1,2,3,4,5,6,7);
        assertEquals("IN", individuoNormal.toString());
    }
}