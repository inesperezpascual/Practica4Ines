package es.uah.metod.practica4ines;

import javafx.beans.property.*;


/** Esta es una clase de utilidad, que permite generar unas propiedades observables para el GUI a partir
 *  de los datos del modelo original de java.
 *  Tiene los métodos de commit y rollback para establecer la operación final de traspasar los datos modificados
 *  o reiniciarlos según se quiera.
 */
public class ParameterDataModelProperties {
    //Modelo de datos original
    protected ParameterDataModel original;

    /** Primer TAB **/
    private IntegerProperty columnas = new SimpleIntegerProperty();
    private IntegerProperty filas = new SimpleIntegerProperty();

    private DoubleProperty velocidad = new SimpleDoubleProperty();

    /** Segundo TAB **/
    private IntegerProperty turnosVida = new SimpleIntegerProperty();
    private IntegerProperty probReprod = new SimpleIntegerProperty();
    private IntegerProperty probClon = new SimpleIntegerProperty();

    /** Tercer TAB **/
    private IntegerProperty agua = new SimpleIntegerProperty();
    private IntegerProperty comida = new SimpleIntegerProperty();
    private IntegerProperty montaña = new SimpleIntegerProperty();
    private IntegerProperty tesoro = new SimpleIntegerProperty();
    private IntegerProperty biblioteca = new SimpleIntegerProperty();
    private IntegerProperty pozo = new SimpleIntegerProperty();

    /** Cuarto TAB **/
    private IntegerProperty probNuevoRecurso = new SimpleIntegerProperty();
    private IntegerProperty probAgua = new SimpleIntegerProperty();
    private IntegerProperty probComida = new SimpleIntegerProperty();
    private IntegerProperty probMontaña = new SimpleIntegerProperty();
    private IntegerProperty probTesoro = new SimpleIntegerProperty();
    private IntegerProperty probBiblioteca = new SimpleIntegerProperty();
    private IntegerProperty probPozo = new SimpleIntegerProperty();


    public ParameterDataModelProperties(ParameterDataModel original){
        setOriginal(original);
    }

    public void commit(){
        original.setColumnas(columnas.get());
        original.setFilas(filas.get());
        original.setVelocidad(velocidad.get());
        original.setTurnosVida(turnosVida.get());
        original.setProbReprod(probReprod.get());
        original.setProbClon(probClon.get());
        original.setAgua(agua.get());
        original.setComida(comida.get());
        original.setMontaña(montaña.get());
        original.setTesoro(tesoro.get());
        original.setBiblioteca(biblioteca.get());
        original.setPozo(pozo.get());
        original.setProbNuevoRecurso(probNuevoRecurso.get());
        original.setProbAgua(probAgua.get());
        original.setProbComida(probComida.get());
        original.setProbMontaña(probMontaña.get());
        original.setProbTesoro(probTesoro.get());
        original.setProbBiblioteca(probBiblioteca.get());
        original.setProbPozo(probPozo.get());
    }

    public void rollback(){
        columnas.set(original.getColumnas());
        filas.set(original.getFilas());
        velocidad.set(original.getVelocidad());
        turnosVida.set(original.getTurnosVida());
        probReprod.set(original.getProbReprod());
        probClon.set(original.getProbClon());
        agua.set(original.getAgua());
        comida.set(original.getComida());
        montaña.set(original.getMontaña());
        tesoro.set(original.getTesoro());
        biblioteca.set(original.getBiblioteca());
        pozo.set(original.getPozo());
        probNuevoRecurso.set(original.getProbNuevoRecurso());
        probAgua.set(original.getProbAgua());
        probComida.set(original.getProbComida());
        probMontaña.set(original.getProbMontaña());
        probTesoro.set(original.getProbTesoro());
        probBiblioteca.set(original.getProbBiblioteca());
        probPozo.set(original.getProbPozo());
    }

    public ParameterDataModel getOriginal(){
        return original;
    }

    public void setOriginal(ParameterDataModel original){
        this.original = original;
        rollback(); //Se inicializan los properties.

    }

    public Property<Number> columnasProperty() {
        return columnas;
    }

    public Property<Number> filasProperty() {
        return filas;
    }

    public Property<Number> velocidadProperty() { return velocidad;}

    public Property<Number> turnosVidaProperty() {
        return turnosVida;
    }

    public Property<Number> probReprodProperty() { return probReprod; }

    public Property<Number> probClonProperty() { return probClon; }

    public Property<Number> aguaProperty() { return agua; }

    public Property<Number> comidaProperty() { return comida; }

    public Property<Number> montañaProperty() { return montaña; }

    public Property<Number> tesoroProperty() { return tesoro; }

    public Property<Number> bibliotecaProperty() { return biblioteca; }

    public Property<Number> pozoProperty() { return pozo; }

    public Property<Number> probNuevoRecursoProperty() { return probNuevoRecurso; }

    public Property<Number> probAguaProperty() { return probAgua; }

    public Property<Number> probComidaProperty() { return probComida; }

    public Property<Number> probMontañaProperty() { return probMontaña; }

    public Property<Number> probTesoroProperty() { return probTesoro; }

    public Property<Number> probBibliotecaProperty() { return probBiblioteca; }

    public Property<Number> probPozoProperty() { return probPozo; }
}
