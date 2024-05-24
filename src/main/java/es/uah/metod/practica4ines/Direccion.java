package es.uah.metod.practica4ines;

public class Direccion {
    private int id;
    private int columnaCelda;
    private int filaCelda;

    public Direccion(int id, int columnaCelda, int filaCelda) {
        this.id = id;
        this.columnaCelda = columnaCelda;
        this.filaCelda = filaCelda;
    }

    public int getId() {
        return id;
    }

    public int getColumnaCelda() {
        return columnaCelda;
    }

    public int getFilaCelda() {
        return filaCelda;
    }
}
