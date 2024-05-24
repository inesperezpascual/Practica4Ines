package es.uah.metod.practica4ines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTest {

    @Test
    void actualizar() {
        Individuo individuo = new Individuo(1,2,3,4,5,6,7);
        assertDoesNotThrow(()->individuo.actualizar());
        assertEquals(2, individuo.getTurnosVida());
        assertEquals(3.6, individuo.getProbReprod());
        assertEquals(4.5, individuo.getProbClon());
    }

    @Test
    void move() {
        Individuo individuo = new Individuo(1,2,3,4,5,6,7);
        assertDoesNotThrow(()->individuo.move(1,2));
    }

    @Test
    void getId() {
        Individuo individuo = new Individuo(1,2,3,4,5,6,7);
        assertEquals(1, individuo.getId());
    }


    @Test
    void getGeneracion() {
        Individuo individuo = new Individuo(1,2,3,4,5,6,7);
        assertEquals(2, individuo.getGeneracion());
    }


    @Test
    void getTurnosVida() {
        Individuo individuo = new Individuo(1,2,3,4,5,6,7);
        assertEquals(3, individuo.getTurnosVida());
    }

    @Test
    void setTurnosVida() {
        Individuo individuo = new Individuo(1,2,3,4,5,6,7);
        assertDoesNotThrow(()-> individuo.setTurnosVida(4));
        assertEquals(4, individuo.getTurnosVida());
    }

    @Test
    void getProbReprod() {
        Individuo individuo = new Individuo(1,2,3,4,5,6,7);
        assertEquals(4, individuo.getProbReprod());
    }

    @Test
    void setProbReprod() {
        Individuo individuo = new Individuo(1,2,3,4,5,6,7);
        assertDoesNotThrow(()-> individuo.setProbReprod(5));
        assertEquals(5, individuo.getProbReprod());
    }

    @Test
    void getProbClon() {
        Individuo individuo = new Individuo(1,2,3,4,5,6,7);
        assertEquals(5, individuo.getProbClon());
    }

    @Test
    void setProbClon() {
        Individuo individuo = new Individuo(1,2,3,4,5,6,7);
        assertDoesNotThrow(()-> individuo.setProbClon(4));
        assertEquals(4, individuo.getProbClon());
    }

    @Test
    void getProbMuerte() {
        Individuo individuo = new Individuo(1,2,3,4,5,6,7);
        assertEquals(6, individuo.getProbMuerte());
    }

    @Test
    void setProbMuerte() {
        Individuo individuo = new Individuo(1,2,3,4,5,6,7);
        assertDoesNotThrow(()-> individuo.setProbMuerte(4));
        assertEquals(4, individuo.getProbMuerte());
    }

    @Test
    void getTipo() {
        Individuo individuo = new Individuo(1,2,3,4,5,6,7);
        assertEquals(7, individuo.getTipo());
    }
}