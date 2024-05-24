package es.uah.metod.practica4ines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParameterDataModelTest {

    @Test
    void setcero() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setcero());
        assertEquals(0, original.getColumnas());
        assertEquals(0, original.getFilas());
        assertEquals(1.0, original.getVelocidad());
        assertEquals(0, original.getTurnosVida());
        assertEquals(0, original.getProbReprod());
        assertEquals(0, original.getProbClon());
        assertEquals(0, original.getAgua());
        assertEquals(0, original.getComida());
        assertEquals(0, original.getMontaña());
        assertEquals(0, original.getTesoro());
        assertEquals(0, original.getBiblioteca());
        assertEquals(0, original.getPozo());
        assertEquals(0, original.getProbNuevoRecurso());
        assertEquals(0, original.getProbAgua());
        assertEquals(0, original.getProbComida());
        assertEquals(0, original.getProbMontaña());
        assertEquals(0, original.getProbTesoro());
        assertEquals(0, original.getProbBiblioteca());
        assertEquals(0, original.getProbPozo());
    }

    @Test
    void getColumnas() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(1, original.getColumnas());
    }

    @Test
    void setColumnas() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setColumnas(2));
        assertEquals(2, original.getColumnas());
    }

    @Test
    void getFilas() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(2, original.getFilas());
    }

    @Test
    void setFilas() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setFilas(1));
        assertEquals(1, original.getFilas());
    }

    @Test
    void getVelocidad() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(3, original.getVelocidad());
    }

    @Test
    void setVelocidad() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setVelocidad(2));
        assertEquals(2, original.getVelocidad());
    }

    @Test
    void getTurnosVida() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(4, original.getTurnosVida());
    }

    @Test
    void setTurnosVida() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setTurnosVida(2));
        assertEquals(2, original.getTurnosVida());
    }

    @Test
    void getProbReprod() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(5, original.getProbReprod());
    }

    @Test
    void setProbReprod() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setProbReprod(2));
        assertEquals(2, original.getProbReprod());
    }

    @Test
    void getProbClon() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(6, original.getProbClon());
    }

    @Test
    void setProbClon() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setProbClon(2));
        assertEquals(2, original.getProbClon());
    }

    @Test
    void getAgua() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(7, original.getAgua());
    }

    @Test
    void setAgua() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setAgua(2));
        assertEquals(2, original.getAgua());
    }

    @Test
    void getComida() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(8, original.getComida());
    }

    @Test
    void setComida() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setComida(2));
        assertEquals(2, original.getComida());
    }

    @Test
    void getMontaña() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(9, original.getMontaña());
    }

    @Test
    void setMontaña() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setMontaña(2));
        assertEquals(2, original.getMontaña());
    }

    @Test
    void getTesoro() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(10, original.getTesoro());
    }

    @Test
    void setTesoro() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setTesoro(2));
        assertEquals(2, original.getTesoro());
    }

    @Test
    void getBiblioteca() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(11, original.getBiblioteca());
    }

    @Test
    void setBiblioteca() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setBiblioteca(2));
        assertEquals(2, original.getBiblioteca());
    }

    @Test
    void getPozo() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(12, original.getPozo());
    }

    @Test
    void setPozo() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setPozo(2));
        assertEquals(2, original.getPozo());
    }

    @Test
    void getProbNuevoRecurso() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(13, original.getProbNuevoRecurso());
    }

    @Test
    void setProbNuevoRecurso() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setProbNuevoRecurso(2));
        assertEquals(2, original.getProbNuevoRecurso());
    }

    @Test
    void getProbAgua() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(14, original.getProbAgua());
    }

    @Test
    void setProbAgua() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setProbAgua(2));
        assertEquals(2, original.getProbAgua());
    }

    @Test
    void getProbComida() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(15, original.getProbComida());
    }

    @Test
    void setProbComida() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setProbComida(2));
        assertEquals(2, original.getProbComida());
    }

    @Test
    void getProbMontaña() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(16, original.getProbMontaña());
    }

    @Test
    void setProbMontaña() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setProbMontaña(2));
        assertEquals(2, original.getProbMontaña());
    }

    @Test
    void getProbTesoro() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(17, original.getProbTesoro());
    }

    @Test
    void setProbTesoro() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setProbTesoro(2));
        assertEquals(2, original.getProbTesoro());
    }

    @Test
    void getProbBiblioteca() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(18, original.getProbBiblioteca());
    }

    @Test
    void setProbBiblioteca() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setProbBiblioteca(2));
        assertEquals(2, original.getProbBiblioteca());
    }

    @Test
    void getProbPozo() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertEquals(19, original.getProbPozo());
    }

    @Test
    void setProbPozo() {
        ParameterDataModel original = new ParameterDataModel(1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        assertDoesNotThrow(()->original.setProbPozo(2));
        assertEquals(2, original.getProbPozo());
    }
}