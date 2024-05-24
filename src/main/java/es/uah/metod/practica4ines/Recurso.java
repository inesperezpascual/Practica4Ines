package es.uah.metod.practica4ines;

public class Recurso {

    private int id;
    private String tipo;
    private int tiempoAparicion;

    public Recurso(int id, String tipo, int tiempoAparicion) {

        this.id = id;

        if (tipo == "Agua" || tipo == "Com" || tipo == "Mont" || tipo == "Tes" || tipo == "Biblio" || tipo == "Pozo"){
            this.tipo = tipo;
        } else {
            System.out.println("El género no es válido.");
        }
        this.tiempoAparicion = tiempoAparicion;
    }

    public int getId() {
        return id;
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
