package es.uah.metod.practica4ines;

public class Recurso {

    private String tipo;
    private int tiempoAparicion;

    public Recurso(String tipo, int tiempoAparicion) {
        if (tipo == "Agua" || tipo == "Com" || tipo == "Mont" || tipo == "Tes" || tipo == "Biblio" || tipo == "Pozo"){
            this.tipo = tipo;
        } else {
            System.out.println("El género no es válido.");
        }
        this.tipo = tipo;
        this.tiempoAparicion = tiempoAparicion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getTiempoAparicion() {
        return tiempoAparicion;
    }

    public void actualizar() {
        this.tiempoAparicion --;
    }

    @Override
    public String toString() {
        return "R" + tipo;
    }
}
