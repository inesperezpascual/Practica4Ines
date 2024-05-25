package es.uah.metod.practica4ines;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Individuo {

    private int id;
    private int generacion;
    private int turnosVida;
    private double probReprod;
    private double probClon;
    private double probMuerte;
    private int tipo;

    public Individuo(int id, int generacion, int turnosVida, double probReprod,
                     double probClon, double probMuerte, int tipo) {
        this.id = id;
        this.generacion = generacion;
        this.turnosVida = turnosVida;
        this.probReprod = probReprod;
        this.probClon = probClon;
        this.probMuerte = probMuerte;
        this.tipo = tipo;
    }



    public void actualizar() {
        turnosVida--;
        probReprod -= 0.1 * probReprod;
        probClon -= 0.1 * probClon;
    }

    public void move(int minimo, int maximo) {} //Luego tienes que poner que devuelve List<Integer>



    public int getId() {
        return id;
    }

    public int getGeneracion() {
        return generacion;
    }

    public int getTurnosVida() {
        return turnosVida;
    }

    public void setTurnosVida(int turnosVida) {
        this.turnosVida = turnosVida;
    }

    public double getProbReprod() {
        return probReprod;
    }

    public void setProbReprod(double probReprod) {
        this.probReprod = probReprod;
    }

    public double getProbClon() {
        return probClon;
    }

    public void setProbClon(double probClon) {
        this.probClon = probClon;
    }

    public double getProbMuerte() {
        return probMuerte;
    }

    public void setProbMuerte(double probMuerte) {
        this.probMuerte = probMuerte;
    }

    public int getTipo() {
        return tipo;
    }
}
