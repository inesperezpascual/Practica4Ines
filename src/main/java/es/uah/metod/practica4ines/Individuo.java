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
    //private Map<String, Individuo> padres;

    public Individuo(int id, int generacion, int turnosVida, double probReprod,
                     double probClon, double probMuerte, int tipo) {
        this.id = id;
        this.generacion = generacion;
        this.turnosVida = turnosVida;
        this.probReprod = probReprod;
        this.probClon = probClon;
        this.probMuerte = probMuerte;
        this.tipo = tipo;
        //this.padres = new TreeMap<>();
    }

    /**public Map<String, Individuo> getPadresYAncestros() {
        return padres;
    }

    public void agregarPadreYAncestros(Individuo padre) {
        if (!this.padres.containsKey(Integer.toString(padre.getId()))) {
            this.padres.put(Integer.toString(padre.getId()), padre);
            for (Individuo ancestro : padre.getPadresYAncestros().values()) {
                agregarPadreYAncestros(ancestro);
            }
            ;
        }
    }

    public void setPadres(Individuo padre1, Individuo padre2) {
        agregarPadreYAncestros(padre1);
        agregarPadreYAncestros(padre2);
    }
    public void imprimirGenealogia() {
        System.out.println("Individuo #" + id + ":");
        System.out.println("  Padres:");
        for (Map.Entry<String, Individuo> entry : padres.entrySet()) {
            Individuo padre = entry.getValue();
            System.out.println("    - Individuo #" + padre.id);
        }

        System.out.println("  Ancestros:");
        for (Map.Entry<String, Individuo> entry : padres.entrySet()) {
            Individuo padre = entry.getValue();
            imprimirAncestros(padre, 2, "Padre");
        }
    }

    private void imprimirAncestros(Individuo individuo, int separacion, String relacion) {
        System.out.println("  ".repeat(separacion) + relacion + " Individuo #" + individuo.id);
        for (Map.Entry<String, Individuo> vertice : individuo.padres.entrySet()) {
            Individuo ancestro = vertice.getValue();
            imprimirAncestros(ancestro, separacion + 1, "Padre");
        }
    }**/


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
