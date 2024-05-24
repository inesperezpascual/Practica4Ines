package es.uah.metod.practica4ines;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class CeldaTest {

    @Test
    void agregarIndividuo() {
        Celda celda = new Celda(1,2);
        IndividuoBasico individuo = new IndividuoBasico(1,1,1,1,1,1,1);
        assertDoesNotThrow(()->celda.agregarIndividuo(individuo));
        ArrayList<Individuo> array = new ArrayList<>();
        array.add(individuo);
        assertEquals(array, celda.getIndividuos());
    }

    @Test
    void quitarIndividuo() {
        Celda celda = new Celda(1,2);
        IndividuoBasico individuo = new IndividuoBasico(1,1,1,1,1,1,1);
        assertDoesNotThrow(()->celda.agregarIndividuo(individuo));
        ArrayList<Individuo> array = new ArrayList<>();
        array.add(individuo);
        assertEquals(array, celda.getIndividuos());
        assertDoesNotThrow(()->celda.quitarIndividuo(individuo));
        array.remove(individuo);
        assertEquals(array, celda.getIndividuos());
    }

    @Test
    void agregarRecurso() {
        Celda celda = new Celda(1,2);
        Recurso recurso = new Recurso(1,"Mont", 1);
        assertDoesNotThrow(()->celda.agregarRecurso(recurso));
        ArrayList<Recurso> array = new ArrayList<>();
        array.add(recurso);
        assertEquals(array, celda.getRecursos());
    }

    @Test
    void quitarRecurso() {
        Celda celda = new Celda(1,2);
        Recurso recurso = new Recurso(1,"Mont", 1);
        assertDoesNotThrow(()->celda.agregarRecurso(recurso));
        ArrayList<Recurso> array = new ArrayList<>();
        array.add(recurso);
        assertEquals(array, celda.getRecursos());
        assertDoesNotThrow(()->celda.quitarRecurso(recurso));
        array.remove(recurso);
        assertEquals(array, celda.getRecursos());
    }


    @Test
    void getColumna() {
        Celda celda = new Celda(1,2);
        assertEquals(1, celda.getColumna());
    }
    @Test
    void getFila() {
        Celda celda = new Celda(1,2);
        assertEquals(2, celda.getFila());
    }

    @Test
    void getIndividuos() {
        Celda celda = new Celda(1,2);
        IndividuoBasico individuo = new IndividuoBasico(1,1,1,1,1,1,1);
        celda.agregarIndividuo(individuo);
        ArrayList<Individuo> array = new ArrayList<>();
        array.add(individuo);
        assertEquals(array, celda.getIndividuos());
    }

    @Test
    void getRecursos() {
        Celda celda = new Celda(1,2);
        Recurso recurso = new Recurso(1,"Mont", 1);
        celda.agregarRecurso(recurso);
        ArrayList<Recurso> array = new ArrayList<>();
        array.add(recurso);
        assertEquals(array, celda.getRecursos());
    }
}