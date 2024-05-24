package es.uah.metod.practica4ines;

/** Esta es la clase del modelo de datos básico **/
public class ParameterDataModel {

    /** Primer TAB **/
    private int columnas;
    private int filas;
    private double  velocidad;

    /** Segundo TAB **/
    private int turnosVida;
    private int probReprod;
    private int probClon;

    /** Tercer TAB **/

    private int agua;
    private int comida;
    private int montaña;
    private int tesoro;
    private int biblioteca;
    private int pozo;

    /** Cuarto TAB **/

    private int probNuevoRecurso;
    private int probAgua;
    private int probComida;
    private int probMontaña;
    private int probTesoro;
    private int probBiblioteca;
    private int probPozo;





    /** Constructor **/
    public ParameterDataModel(int columnas, int filas, double velocidad, int turnosVida, int probReprod, int probClon,
                              int agua, int comida, int montaña, int tesoro, int biblioteca, int pozo,
                              int probNuevoRecurso, int probAgua, int probComida, int probMontaña, int probTesoro, int probBiblioteca, int probPozo) {
        this.columnas = columnas;
        this.filas = filas;
        this.velocidad = velocidad;
        this.turnosVida = turnosVida;
        this.probReprod = probReprod;
        this.probClon = probClon;
        this.agua = agua;
        this.comida = comida;
        this.montaña = montaña;
        this.tesoro = tesoro;
        this.biblioteca = biblioteca;
        this.pozo = pozo;
        this.probNuevoRecurso = probNuevoRecurso;
        this.probAgua = probAgua;
        this.probComida = probComida;
        this.probMontaña = probMontaña;
        this.probTesoro = probTesoro;
        this.probBiblioteca = probBiblioteca;
        this.probPozo = probPozo;
    }

    public void setcero() {
        this.columnas = 0;
        this.filas = 0;
        this.velocidad = 1.0;
        this.turnosVida = 0;
        this.probReprod = 0;
        this.probClon = 0;
        this.agua = 0;
        this.comida = 0;
        this.montaña = 0;
        this.tesoro = 0;
        this.biblioteca = 0;
        this.pozo = 0;
        this.probNuevoRecurso = 0;
        this.probAgua = 0;
        this.probComida = 0;
        this.probMontaña = 0;
        this.probTesoro = 0;
        this.probBiblioteca = 0;
        this.probPozo = 0;
    }

    /** Setters y Getters **/

    /** Primer TAB **/
    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    /** Segundo TAB **/

    public int getTurnosVida() {
        return turnosVida;
    }

    public void setTurnosVida(int turnosVida) {
        this.turnosVida = turnosVida;
    }

    public int getProbReprod() {
        return probReprod;
    }

    public void setProbReprod(int probReprod) {
        this.probReprod = probReprod;
    }

    public int getProbClon() {
        return probClon;
    }

    public void setProbClon(int probClon) { this.probClon = probClon; }


    /** Tercer TAB **/

    public int getAgua() { return agua;  }

    public void setAgua(int agua) { this.agua = agua;   }

    public int getComida() { return comida;  }

    public void setComida(int comida) { this.comida = comida;  }

    public int getMontaña() { return montaña;  }

    public void setMontaña(int montaña) { this.montaña = montaña;  }

    public int getTesoro() { return tesoro;  }

    public void setTesoro(int tesoro) { this.tesoro = tesoro;  }

    public int getBiblioteca() { return biblioteca;  }

    public void setBiblioteca(int biblioteca) { this.biblioteca = biblioteca;  }

    public int getPozo() { return pozo;  }

    public void setPozo(int pozo) { this.pozo = pozo;  }

    /** Cuarto TAB **/

    public int getProbNuevoRecurso() {
        return probNuevoRecurso;
    }

    public void setProbNuevoRecurso(int probNuevoRecurso) {
        this.probNuevoRecurso = probNuevoRecurso;
    }

    public int getProbAgua() {
        return probAgua;
    }

    public void setProbAgua(int probAgua) {
        this.probAgua = probAgua;
    }

    public int getProbComida() {
        return probComida;
    }

    public void setProbComida(int probComida) {
        this.probComida = probComida;
    }

    public int getProbMontaña() {
        return probMontaña;
    }

    public void setProbMontaña(int probMontaña) {
        this.probMontaña = probMontaña;
    }

    public int getProbTesoro() {
        return probTesoro;
    }

    public void setProbTesoro(int probTesoro) {
        this.probTesoro = probTesoro;
    }

    public int getProbBiblioteca() {
        return probBiblioteca;
    }

    public void setProbBiblioteca(int probBiblioteca) {
        this.probBiblioteca = probBiblioteca;
    }

    public int getProbPozo() {
        return probPozo;
    }

    public void setProbPozo(int probPozo) {
        this.probPozo = probPozo;
    }
}
