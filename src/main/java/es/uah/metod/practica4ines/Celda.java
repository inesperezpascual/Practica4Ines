package es.uah.metod.practica4ines;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Celda extends Pane {

    private int columna;
    private int fila;
    private ArrayList<Individuo> individuos;
    private ArrayList<Recurso> recursos;

    public Celda(int columna, int fila) {
        this.columna = columna;
        this.fila = fila;
        this.individuos = new ArrayList<>();
        this.recursos = new ArrayList<>();
    }

    public void agregarIndividuo(Individuo individuo) {
        individuos.add(individuo);
    }

    public void quitarIndividuo(Individuo individuo) {
        individuos.remove(individuo);
    }

    public void agregarRecurso(Recurso recurso) {
        recursos.add(recurso);
    }

    public void quitarRecurso(Recurso recurso) {
        recursos.remove(recurso);
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public List<Individuo> getIndividuos() {
        return individuos;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

}
