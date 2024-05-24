package es.uah.metod.practica4ines;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParameterDataModelPropertiesTest {

    @Test
    void commit() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.columnasProperty().setValue(20);
        properties.filasProperty().setValue(21);
        properties.velocidadProperty().setValue(22.0);
        properties.turnosVidaProperty().setValue(23);
        properties.probReprodProperty().setValue(24);
        properties.probClonProperty().setValue(25);
        properties.aguaProperty().setValue(26);
        properties.comidaProperty().setValue(27);
        properties.montañaProperty().setValue(28);
        properties.tesoroProperty().setValue(29);
        properties.bibliotecaProperty().setValue(30);
        properties.pozoProperty().setValue(31);
        properties.probNuevoRecursoProperty().setValue(32);
        properties.probAguaProperty().setValue(33);
        properties.probComidaProperty().setValue(34);
        properties.probMontañaProperty().setValue(35);
        properties.probTesoroProperty().setValue(36);
        properties.probBibliotecaProperty().setValue(37);
        properties.probPozoProperty().setValue(38);

        properties.commit();

        assertEquals(20, original.getColumnas());
        assertEquals(21, original.getFilas());
        assertEquals(22.0, original.getVelocidad());
        assertEquals(23, original.getTurnosVida());
        assertEquals(24, original.getProbReprod());
        assertEquals(25, original.getProbClon());
        assertEquals(26, original.getAgua());
        assertEquals(27, original.getComida());
        assertEquals(28, original.getMontaña());
        assertEquals(29, original.getTesoro());
        assertEquals(30, original.getBiblioteca());
        assertEquals(31, original.getPozo());
        assertEquals(32, original.getProbNuevoRecurso());
        assertEquals(33, original.getProbAgua());
        assertEquals(34, original.getProbComida());
        assertEquals(35, original.getProbMontaña());
        assertEquals(36, original.getProbTesoro());
        assertEquals(37, original.getProbBiblioteca());
        assertEquals(38, original.getProbPozo());
    }

    @Test
    void rollback() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.columnasProperty().setValue(20);
        properties.filasProperty().setValue(21);
        properties.velocidadProperty().setValue(22.0);
        properties.turnosVidaProperty().setValue(23);
        properties.probReprodProperty().setValue(24);
        properties.probClonProperty().setValue(25);
        properties.aguaProperty().setValue(26);
        properties.comidaProperty().setValue(27);
        properties.montañaProperty().setValue(28);
        properties.tesoroProperty().setValue(29);
        properties.bibliotecaProperty().setValue(30);
        properties.pozoProperty().setValue(31);
        properties.probNuevoRecursoProperty().setValue(32);
        properties.probAguaProperty().setValue(33);
        properties.probComidaProperty().setValue(34);
        properties.probMontañaProperty().setValue(35);
        properties.probTesoroProperty().setValue(36);
        properties.probBibliotecaProperty().setValue(37);
        properties.probPozoProperty().setValue(38);

        properties.rollback();

        assertEquals(original.getColumnas(), properties.columnasProperty().getValue());
        assertEquals(original.getFilas(), properties.filasProperty().getValue());
        assertEquals(original.getVelocidad(), properties.velocidadProperty().getValue());
        assertEquals(original.getTurnosVida(), properties.turnosVidaProperty().getValue());
        assertEquals(original.getProbReprod(), properties.probReprodProperty().getValue());
        assertEquals(original.getProbClon(), properties.probClonProperty().getValue());
        assertEquals(original.getAgua(), properties.aguaProperty().getValue());
        assertEquals(original.getComida(), properties.comidaProperty().getValue());
        assertEquals(original.getMontaña(), properties.montañaProperty().getValue());
        assertEquals(original.getTesoro(), properties.tesoroProperty().getValue());
        assertEquals(original.getBiblioteca(), properties.bibliotecaProperty().getValue());
        assertEquals(original.getPozo(), properties.pozoProperty().getValue());
        assertEquals(original.getProbNuevoRecurso(), properties.probNuevoRecursoProperty().getValue());
        assertEquals(original.getProbAgua(), properties.probAguaProperty().getValue());
        assertEquals(original.getProbComida(), properties.probComidaProperty().getValue());
        assertEquals(original.getProbMontaña(), properties.probMontañaProperty().getValue());
        assertEquals(original.getProbTesoro(), properties.probTesoroProperty().getValue());
        assertEquals(original.getProbBiblioteca(), properties.probBibliotecaProperty().getValue());
        assertEquals(original.getProbPozo(), properties.probPozoProperty().getValue());
    }

    @Test
    void getOriginal() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        assertEquals(original, properties.getOriginal());
    }

    @Test
    void setOriginal() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModel original2 = new ParameterDataModel(2,2,2.0,2,2,2,2,2,2,
                2,2,2,2,2,2,2,2,2,2);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        assertDoesNotThrow(()-> properties.setOriginal(original2));
        assertEquals(original2, properties.getOriginal());
    }

    @Test
    void columnasProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.columnasProperty().setValue(20);
        assertEquals(20, properties.columnasProperty().getValue());
    }

    @Test
    void filasProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.filasProperty().setValue(20);
        assertEquals(20, properties.filasProperty().getValue());
    }

    @Test
    void velocidadProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.velocidadProperty().setValue(20.0);
        assertEquals(20.0, properties.velocidadProperty().getValue());
    }

    @Test
    void turnosVidaProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.turnosVidaProperty().setValue(20);
        assertEquals(20, properties.turnosVidaProperty().getValue());
    }

    @Test
    void probReprodProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.probReprodProperty().setValue(20);
        assertEquals(20, properties.probReprodProperty().getValue());
    }

    @Test
    void probClonProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.probClonProperty().setValue(20);
        assertEquals(20, properties.probClonProperty().getValue());
    }

    @Test
    void aguaProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.aguaProperty().setValue(20);
        assertEquals(20, properties.aguaProperty().getValue());
    }

    @Test
    void comidaProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.comidaProperty().setValue(20);
        assertEquals(20, properties.comidaProperty().getValue());
    }

    @Test
    void montañaProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.montañaProperty().setValue(20);
        assertEquals(20, properties.montañaProperty().getValue());
    }

    @Test
    void tesoroProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.tesoroProperty().setValue(20);
        assertEquals(20, properties.tesoroProperty().getValue());
    }

    @Test
    void bibliotecaProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.bibliotecaProperty().setValue(20);
        assertEquals(20, properties.bibliotecaProperty().getValue());
    }

    @Test
    void pozoProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.pozoProperty().setValue(20);
        assertEquals(20, properties.pozoProperty().getValue());
    }

    @Test
    void probNuevoRecursoProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.probNuevoRecursoProperty().setValue(20);
        assertEquals(20, properties.probNuevoRecursoProperty().getValue());
    }

    @Test
    void probAguaProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.probAguaProperty().setValue(20);
        assertEquals(20, properties.probAguaProperty().getValue());
    }

    @Test
    void probComidaProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.probComidaProperty().setValue(20);
        assertEquals(20, properties.probComidaProperty().getValue());
    }

    @Test
    void probMontañaProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.probMontañaProperty().setValue(20);
        assertEquals(20, properties.probMontañaProperty().getValue());
    }

    @Test
    void probTesoroProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.probTesoroProperty().setValue(20);
        assertEquals(20, properties.probTesoroProperty().getValue());
    }

    @Test
    void probBibliotecaProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.probBibliotecaProperty().setValue(20);
        assertEquals(20, properties.probBibliotecaProperty().getValue());
    }

    @Test
    void probPozoProperty() {
        ParameterDataModel original = new ParameterDataModel(1,2,3.0,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19);
        ParameterDataModelProperties properties = new ParameterDataModelProperties(original);
        properties.probPozoProperty().setValue(20);
        assertEquals(20, properties.probPozoProperty().getValue());
    }
}