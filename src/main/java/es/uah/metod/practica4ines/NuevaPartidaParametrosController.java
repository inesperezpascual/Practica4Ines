package es.uah.metod.practica4ines;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static es.uah.metod.practica4ines.MainApplication.log;

public class NuevaPartidaParametrosController implements Initializable {


    @FXML
    private Label welcomeText;

    @FXML
    private Pane paneTablero;

    @FXML
    private GridPane tableroDeJuego = new GridPane();

    private ArrayList<Celda> listaceldas = new ArrayList<>();

    private boolean partidapausa;

    @FXML
    private Button botonPausar;

    @FXML
    private Button botonTerminar;

    private int idIndividuos = 0;
    private int velocidadAdaptadaANIMATION = 50;

    @FXML
    private Label labelTurno;
    private int turnoPartida = 1;

    @FXML
    private Button botonJugar;

    protected double fontSize;


    private Partida partida = new Partida();



    /**Dani
     private int velocidad = 50;
    @FXML
     private Label lblTurno;

     EscenariosController controladorEscenarios;

     private Partida partida;

     private Boolean tableroCreado = false;

     private Boolean partidaCreada = false;

    @FXML
     private Button btnStart;
     @FXML
     private Button btnPausa;
    **/

    /**
     * Hooks de conexión entre los controles visuales y el código, llevan @FXML para identificarlos
     **/

    @FXML
    private Label labelValorSliderColumnas;
    @FXML
    private Label labelValorSliderFilas;
    @FXML
    private Label labelValorSliderVelocidad;
    @FXML
    private Label labelValorSliderTurnosVida;
    @FXML
    private Label labelValorSliderProbReprod;
    @FXML
    private Label labelValorSliderProbClon;
    @FXML
    private Label labelValorSliderAgua;
    @FXML
    private Label labelValorSliderComida;
    @FXML
    private Label labelValorSliderMontaña;
    @FXML
    private Label labelValorSliderTesoro;
    @FXML
    private Label labelValorSliderBiblioteca;
    @FXML
    private Label labelValorSliderPozo;
    @FXML
    private Label labelValorSliderProbNuevoRecurso;
    @FXML
    private Label labelValorSliderProbAgua;
    @FXML
    private Label labelValorSliderProbComida;
    @FXML
    private Label labelValorSliderProbMontaña;
    @FXML
    private Label labelValorSliderProbTesoro;
    @FXML
    private Label labelValorSliderProbBiblioteca;
    @FXML
    private Label labelValorSliderProbPozo;




    @FXML
    private Slider sliderColumnas;
    @FXML
    private Slider sliderFilas;
    @FXML
    private Slider sliderVelocidad;
    @FXML
    private Slider sliderTurnosVida;
    @FXML
    private Slider sliderProbReprod;
    @FXML
    private Slider sliderProbClon;
    @FXML
    private Slider sliderAgua;
    @FXML
    private Slider sliderComida;
    @FXML
    private Slider sliderMontaña;
    @FXML
    private Slider sliderTesoro;
    @FXML
    private Slider sliderBiblioteca;
    @FXML
    private Slider sliderPozo;
    @FXML
    private Slider sliderProbNuevoRecurso;
    @FXML
    private Slider sliderProbAgua;
    @FXML
    private Slider sliderProbComida;
    @FXML
    private Slider sliderProbMontaña;
    @FXML
    private Slider sliderProbTesoro;
    @FXML
    private Slider sliderProbBiblioteca;
    @FXML
    private Slider sliderProbPozo;


    /**
     * Propiedades "bindeadas" que permite interconectar elementos visuales
     **/
    protected IntegerProperty medidaColumnas = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaFilas = new SimpleIntegerProperty(0);
    protected DoubleProperty medidaVelocidad = new SimpleDoubleProperty(1);
    protected IntegerProperty medidaTurnosVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbReprod = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbClon = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaAgua = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaComida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaMontaña = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaTesoro = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaBiblioteca = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPozo = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbNuevoRecurso = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbAgua = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbComida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbMontaña = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbTesoro = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbBiblioteca = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbPozo = new SimpleIntegerProperty(0);


    /**
     * Controlador con modelo de datos en el que trabajar
     **/
    private ParameterDataModelProperties model;
    private Stage scene;



    @FXML
    public void onBotonAceptarClick() { model.commit();   } //En model se guardan todos los datos.
    @FXML
    public void onBotonReiniciarClick() { model.rollback();   }
    @FXML
    public void onBotonCerrarClick() { scene.close();  }


    public void bindSlidersLabelsInteger(Slider slider, Label label, IntegerProperty medida) {
        slider.valueProperty().bindBidirectional(medida);
        label.textProperty().bind(medida.asString());
    }

    public void bindSlidersLabelsDouble(Slider slider, Label label, DoubleProperty medida) {
        slider.valueProperty().bindBidirectional(medida);
        label.textProperty().bind(medida.asString());
    }


    /**
     * Métodos de configuración
     **/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.debug("Inicialización en ejecución del controlador de parámetros\n");

        paneTablero.getChildren().addAll(tableroDeJuego);
        tableroDeJuego.setGridLinesVisible(true);

        /**changeStateOfLabelColumas();
        changeStateOfLabelFilas();
        changeStateofLabelVelocidad();
        btnPause.setDisable(true);
        btnEnd.setDisable(true);**/

        if (model != null) {
            this.updateGUIwithModel();
        }

        bindSlidersLabelsInteger(sliderColumnas, labelValorSliderColumnas, medidaColumnas);

        bindSlidersLabelsInteger(sliderFilas, labelValorSliderFilas, medidaFilas);

        bindSlidersLabelsDouble(sliderVelocidad, labelValorSliderVelocidad, medidaVelocidad);

        bindSlidersLabelsInteger(sliderTurnosVida, labelValorSliderTurnosVida, medidaTurnosVida);

        bindSlidersLabelsInteger(sliderProbReprod, labelValorSliderProbReprod, medidaProbReprod);

        bindSlidersLabelsInteger(sliderProbClon, labelValorSliderProbClon, medidaProbClon);

        bindSlidersLabelsInteger(sliderAgua, labelValorSliderAgua, medidaAgua);

        bindSlidersLabelsInteger(sliderComida, labelValorSliderComida, medidaComida);

        bindSlidersLabelsInteger(sliderMontaña, labelValorSliderMontaña, medidaMontaña);

        bindSlidersLabelsInteger(sliderTesoro, labelValorSliderTesoro, medidaTesoro);

        bindSlidersLabelsInteger(sliderBiblioteca, labelValorSliderBiblioteca, medidaBiblioteca);

        bindSlidersLabelsInteger(sliderPozo, labelValorSliderPozo, medidaPozo);

        bindSlidersLabelsInteger(sliderProbNuevoRecurso, labelValorSliderProbNuevoRecurso, medidaProbNuevoRecurso);

        bindSlidersLabelsInteger(sliderProbAgua, labelValorSliderProbAgua, medidaProbAgua);

        bindSlidersLabelsInteger(sliderProbComida, labelValorSliderProbComida, medidaProbComida);

        bindSlidersLabelsInteger(sliderProbMontaña, labelValorSliderProbMontaña, medidaProbMontaña);

        bindSlidersLabelsInteger(sliderProbTesoro, labelValorSliderProbTesoro, medidaProbTesoro);

        bindSlidersLabelsInteger(sliderProbBiblioteca, labelValorSliderProbBiblioteca, medidaProbBiblioteca);

        bindSlidersLabelsInteger(sliderProbPozo, labelValorSliderProbPozo, medidaProbPozo);

    }

    /**
     * Este método se encarga de conectar los datos del modelo con el GUI
     **/
    protected void updateGUIwithModel() {
        sliderColumnas.valueProperty().bindBidirectional(model.columnasProperty());
        sliderFilas.valueProperty().bindBidirectional(model.filasProperty());
        sliderVelocidad.valueProperty().bindBidirectional(model.velocidadProperty());
        sliderTurnosVida.valueProperty().bindBidirectional(model.turnosVidaProperty());
        sliderProbReprod.valueProperty().bindBidirectional(model.probReprodProperty());
        sliderProbClon.valueProperty().bindBidirectional(model.probClonProperty());
        sliderAgua.valueProperty().bindBidirectional(model.aguaProperty());
        sliderComida.valueProperty().bindBidirectional(model.comidaProperty());
        sliderMontaña.valueProperty().bindBidirectional(model.montañaProperty());
        sliderTesoro.valueProperty().bindBidirectional(model.tesoroProperty());
        sliderBiblioteca.valueProperty().bindBidirectional(model.bibliotecaProperty());
        sliderPozo.valueProperty().bindBidirectional(model.pozoProperty());
        sliderProbNuevoRecurso.valueProperty().bindBidirectional(model.probNuevoRecursoProperty());
        sliderProbAgua.valueProperty().bindBidirectional(model.probAguaProperty());
        sliderProbComida.valueProperty().bindBidirectional(model.probComidaProperty());
        sliderProbMontaña.valueProperty().bindBidirectional(model.probMontañaProperty());
        sliderProbTesoro.valueProperty().bindBidirectional(model.probTesoroProperty());
        sliderProbBiblioteca.valueProperty().bindBidirectional(model.probBibliotecaProperty());
        sliderProbPozo.valueProperty().bindBidirectional(model.probPozoProperty());

    }

    /**
     * Este método recibe los datos del modelo y los establece
     **/
    public void loadUserData(ParameterDataModelProperties parametrosData) {
        this.model = parametrosData;
        this.updateGUIwithModel();
    }

    public void setStage(Stage s){
        this.scene = s;
    }


    @FXML
    protected void onJugarButtonClick() {
        try {
            log.debug("Ha comenzado la partida");
            welcomeText.setText("Cargando el tablero de juego");
            System.out.println("Hemos llegado al tablero");

            partidapausa = false;
            deshabilitarSliders(true);
            deshabilitarSlidersTablero(true);
            botonJugar.setDisable(true);


            eliminarTablero();

            crearTablero(model.getOriginal().getColumnas(), model.getOriginal().getFilas());

            agregarIndividuosAleatoriosACeldas(3);
            agregarRecursosAleatoriosACeldas(3);

            fontSize = Math.min(paneTablero.getWidth() / model.getOriginal().getColumnas(),
                    paneTablero.getHeight() / model.getOriginal().getFilas()) / 6;

            log.debug("Vamos a imprimir el tablero 1");

            for (Celda celda : listaceldas) {
                System.out.println(celda.getColumna()+" , " + celda.getFila()+ " , "+celda.getIndividuos()+ " , " +celda.getRecursos());
                System.out.println(fontSize);
                mostrarEnCelda(celda, fontSize);
            }
            //System.out.println(model.getOriginal().getVelocidad());
            adaptarVelocidad();
            animationTimer.start();

            log.debug("Hemos pintado el tablero 1");

        } catch (Exception e) {
            // Manejo de la excepción: muestra un mensaje de error al usuario
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Se produjo un error al iniciar el juego");
            alert.setContentText("Detalles del error: " + e.getMessage());
            alert.showAndWait();
        }

    }


    ////////////////////////////////CLASS ANIMATIONTIMER///////////////////////////////////////////////////

    AnimationTimer animationTimer = new AnimationTimer() {
        int i = velocidadAdaptadaANIMATION;
        @Override
        public void handle(long now) {
            try {
                if (i == 0) {
                    turnoPartida++;
                    System.out.println("Turno" + turnoPartida);
                    labelTurno.setText("Turno: " + turnoPartida);
                    i = velocidadAdaptadaANIMATION;
                    moverIndividuos();
                    actualizarIndividuos();
                    actualizarRecursos();
                    System.out.println("Antes de reproducirse");
                    for (Celda celda : listaceldas) {
                        System.out.println(celda.getColumna() + " , " + celda.getFila() + " , " + celda.getIndividuos() + " , " + celda.getRecursos());
                    }
                    evaluarReproducir();
                    System.out.println("Después de reproducirse y antes de morirse");
                    for (Celda celda : listaceldas) {
                        System.out.println(celda.getColumna() + " , " + celda.getFila() + " , " + celda.getIndividuos() + " , " + celda.getRecursos());
                    }
                    System.out.println("Después de morirse");
                    evaluarMorir();
                    for (Celda celda : listaceldas) {
                        System.out.println(celda.getColumna() + " , " + celda.getFila() + " , " + celda.getIndividuos() + " , " + celda.getRecursos());
                    }
                    ArrayList<Celda> celdascopy = new ArrayList<>();
                    for (Celda celda : listaceldas) {
                        celdascopy.add(celda);
                    }
                    eliminarTablero();
                    listaceldas = celdascopy;
                    fontSize = Math.min(paneTablero.getWidth() / model.getOriginal().getColumnas(),
                            paneTablero.getHeight() / model.getOriginal().getFilas()) / 6;
                    log.debug("Vamos a imprimir el tablero " + turnoPartida);
                    crearTableroConCeldas(listaceldas, model.getOriginal().getColumnas(), model.getOriginal().getFilas());
                    for (Celda celda : listaceldas) {
                        System.out.println(celda.getColumna() + " , " + celda.getFila() + " , " + celda.getIndividuos() + " , " + celda.getRecursos());
                        mostrarEnCelda(celda, fontSize);
                    }
                }
                i--;

            } catch (Exception e) {
                // Manejo de la excepción: muestra un mensaje de error al usuario
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Se produjo un error durante la animación");
                alert.setContentText("Detalles del error: " + e.getMessage());
                alert.showAndWait();
            }
        }
    };


    void adaptarVelocidad() {
        log.debug("Se va a adaptar la velocidad");
        try {
            if (model.getOriginal().getVelocidad()==0.25) {
                this.velocidadAdaptadaANIMATION = 125;
            } else if (model.getOriginal().getVelocidad()==0.5) {
                this.velocidadAdaptadaANIMATION = 100;
            } else if (model.getOriginal().getVelocidad()==0.75) {
                this.velocidadAdaptadaANIMATION = 75;
            } else if (model.getOriginal().getVelocidad()==1.25) {
                this.velocidadAdaptadaANIMATION = 40;
            } else if (model.getOriginal().getVelocidad()==1.5) {
                this.velocidadAdaptadaANIMATION = 30;
            } else if (model.getOriginal().getVelocidad()==1.75) {
                this.velocidadAdaptadaANIMATION = 20;
            } else if (model.getOriginal().getVelocidad()==2.0) {
                this.velocidadAdaptadaANIMATION = 10;
            } else {
                this.velocidadAdaptadaANIMATION = 50;
            }
        } catch (NullPointerException e) {
            System.err.println("Error: El modelo original es nulo.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error: Se produjo una excepción no esperada.");
            e.printStackTrace();
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void moverIndividuos(){
        for (Celda celda : listaceldas) {
            List<Individuo> individuoscopy = new ArrayList<>(celda.getIndividuos());

            for (Individuo individuo : individuoscopy) {
                List<Integer> direcciones = null;
                Celda celdanueva = null;

                if (individuo.getTipo() == 0) {
                    IndividuoBasico individuoBasico = (IndividuoBasico) individuo;
                    direcciones = individuoBasico.moveIB(model.getOriginal().getColumnas(), model.getOriginal().getFilas());
                    celda.quitarIndividuo(individuoBasico);
                    celdanueva = getCeldaenDireccion(direcciones.get(0), direcciones.get(1));
                    celdanueva.agregarIndividuo(individuoBasico);
                } //else if (individuo instanceof IndividuoNormal) {
                //IndividuoNormal individuoNormal = (IndividuoNormal) individuo;
                //}


                if (individuo.getTipo() == 1) {
                    List<Celda> celdasConRecursosLineaRecta = new ArrayList<>();

                    for (Celda casillaprueba :listaceldas) {
                        if (casillaprueba.getFila() == celda.getFila() || casillaprueba.getColumna() == celda.getColumna()) {
                            if (!casillaprueba.getRecursos().isEmpty()){
                                celdasConRecursosLineaRecta.add(casillaprueba);
                            }
                        }
                    }
                    //Elegimos aleatoriamente una de las celdas que tiene alrededor en línea recta
                    if (!celdasConRecursosLineaRecta.isEmpty()) {
                        Random random = new Random();
                        Celda celdaDestino = celdasConRecursosLineaRecta.get(random.nextInt(celdasConRecursosLineaRecta.size()));

                        celda.quitarIndividuo(individuo);
                        celdaDestino.agregarIndividuo(individuo);
                    }
                }
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    //////////////////////////////////////////FUNCION EVALUAR QUIEN DEBE MORIR (SIZE>3) ///////////////////////////////////////////////////////////////////////

    public void evaluarMorir() {
        try {
            for (Celda celda : listaceldas) {
                List<Individuo> individuoslista = celda.getIndividuos();
                Collections.sort(individuoslista, Comparator.comparingInt(Individuo::getTurnosVida));
                while (individuoslista.size() > 3) {
                    Iterator<Individuo> iterator = individuoslista.iterator();

                    iterator.next();
                    iterator.remove();
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas o de individuos.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error: Se produjo una excepción no esperada al evaluar morir.");
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    //////////////////////////////////////////////////////////FUNCIONES REPRODUCCION///////////////////////////////////////////////////////////////////////////


    public void evaluarReproducir(){
        try {
            for (Celda celda : listaceldas) {
                List<Individuo> individuoscopy = new ArrayList<>(celda.getIndividuos());
                if (individuoscopy.size() >= 2){
                    for (int i = 0; i < individuoscopy.size()-1; i++) {
                        Individuo individuo1 = individuoscopy.get(i);
                        for (int j = i+1 ; j < individuoscopy.size(); j++) {

                            Individuo individuo2 = individuoscopy.get(j);
                            double probConjunta = (individuo1.getProbReprod() + individuo2.getProbReprod()) / 2;
                            if (probConjunta > 0.5) {
                                reproducir(individuo1, individuo2, celda);
                            }

                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas o de individuos.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error al evaluar la reproducción.");
            e.printStackTrace();
        }
    }

    public void reproducir (Individuo individuo1, Individuo individuo2, Celda celda) {
        try {
            Individuo nuevoIndividuo = null;
            int creartipo = 0;
            if (individuo1.getTipo() == individuo2.getTipo()) {
                if (individuo1.getTipo() == 0) {
                    creartipo = 0;
                } else if (individuo2.getTipo() == 1) {
                    creartipo = 1;
                } else if (individuo2.getTipo() == 2) {
                    creartipo = 2;
                } else {
                    System.out.println("El tipo no es válido, no puede reproducirse");
                }
            } else if (individuo1.getTipo() > individuo2.getTipo()) {
                creartipo = individuo1.getTipo();
            } else if (individuo2.getTipo() > individuo1.getTipo()){
                creartipo = individuo2.getTipo();
            }


            if (creartipo == 0) {
                nuevoIndividuo = new IndividuoBasico(idIndividuos, 0,model.getOriginal().getTurnosVida(),
                        model.getOriginal().getProbReprod(), model.getOriginal().getProbClon(),
                        1 - (model.getOriginal().getProbReprod()), 0);
                idIndividuos ++;
            } else if (creartipo == 1) {
                nuevoIndividuo = new IndividuoNormal(idIndividuos, 0, model.getOriginal().getTurnosVida(),
                        model.getOriginal().getProbReprod(), model.getOriginal().getProbClon(),
                        1 - (model.getOriginal().getProbReprod()), 1);
                idIndividuos ++;
            } else if (creartipo == 2) {
                nuevoIndividuo = new IndividuoAvanzado(idIndividuos, 0, model.getOriginal().getTurnosVida(),
                        model.getOriginal().getProbReprod(), model.getOriginal().getProbClon(),
                        1 - (model.getOriginal().getProbReprod()), 2);
                idIndividuos ++;
            }
            celda.agregarIndividuo(nuevoIndividuo);
        } catch (Exception e) {
            System.err.println("Error al reproducir dos individuos.");
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    /////////////////////////////////////////////////////FUNCIONES ACTUALIZAR INDIVIDUOS Y ENTORNO/////////////////////////////////////////////////////////////


    public void actualizarIndividuos() {
        try {
            for (Celda celda : listaceldas) {
                Iterator<Individuo> iterator = celda.getIndividuos().iterator();
                while (iterator.hasNext()) {
                    Individuo individuo = iterator.next();
                    individuo.actualizar();
                    if (individuo.getTurnosVida() == 0) {
                        iterator.remove();
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas o de individuos.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error al actualizar individuos.");
            e.printStackTrace();
        }
    }
    public void actualizarRecursos() {
        try {
            for (Celda celda : listaceldas) {
                Iterator<Recurso> iterator = celda.getRecursos().iterator();
                while (iterator.hasNext()) {
                    Recurso recurso = iterator.next();
                    recurso.actualizar();
                    if (recurso.getTiempoAparicion() == 0) {
                        iterator.remove();
                    }
                }

                //Vemos a ver si deberíamos crear un nuevo recurso
                if (celda.getRecursos().size() < 3) {

                    double randomProbabilidad = Math.random(); // Número aleatorio entre 0 y 1
                    if (randomProbabilidad < model.getOriginal().getProbNuevoRecurso()) {
                        //ENTONCES CREAMOS NUEVO RECURSO
                        double probTotal = 0.1 * (model.getOriginal().getProbAgua() + model.getOriginal().getProbComida() + model.getOriginal().getProbMontaña() +
                                + model.getOriginal().getTesoro() + model.getOriginal().getProbBiblioteca() + model.getOriginal().getProbPozo());

                        double rangoAgua = 0.1 * (model.getOriginal().getProbAgua()) / probTotal;
                        double rangoComida = (0.1 * (model.getOriginal().getProbComida()) / probTotal) + rangoAgua;
                        double rangoMontaña = (0.1 * (model.getOriginal().getProbMontaña()) / probTotal) + rangoComida;
                        double rangoTesoro = (0.1 * (model.getOriginal().getProbTesoro()) / probTotal) + rangoMontaña;
                        double rangoBiblioteca = (0.1 * (model.getOriginal().getProbBiblioteca()) / probTotal) + rangoTesoro;
                        double rangoPozo = 1.0;

                        double randomRecurso = Math.random();
                        String tipoo = null;

                        if (randomRecurso < rangoAgua){
                            tipoo = "Agua";
                        } else if (randomRecurso < rangoComida) {
                            tipoo = "Com";
                        } else if (randomRecurso < rangoMontaña) {
                            tipoo = "Mont";
                        } else if (randomRecurso < rangoTesoro) {
                            tipoo = "Tes";
                        } else if (randomRecurso < rangoBiblioteca) {
                            tipoo = "Biblio";
                        } else {
                            tipoo = "Pozo";
                        }

                        Recurso nuevoRecurso = new Recurso((String) tipoo, 3);
                        celda.agregarRecurso(nuevoRecurso);
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas o de individuos.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error al actualizar recursos.");
            e.printStackTrace();
        }
    }


    public Celda getCeldaenDireccion(int columna, int fila) {
        try {
            for (Celda celda : listaceldas) {
                if (celda.getColumna() == columna && celda.getFila() == fila) {
                    return celda;
                }
            }
            return null;
        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas.");
            e.printStackTrace();
            return null;

        } catch (Exception e) {
            System.err.println("Error al buscar celda en dirección.");
            e.printStackTrace();
            return null;
        }

    }

    public int numerovivos() {
        int vivos = 0;
        for (Celda celda : listaceldas) {
            for (Individuo individuo : celda.getIndividuos()) {
                vivos ++;
            }
        }
        return vivos;
    }

    public void terminarPartida(){

    }



    ///////////////////////////////////////FUNCIONES CREAR Y ELIMINAR TABLERO////////////////////////////////////////////////////////

    public void crearTablero(int columnas, int filas){
        try {
            double a = paneTablero.getWidth();
            double b = paneTablero.getHeight();

            System.out.println(columnas);
            System.out.println(filas);

            for (int i = 0; i < columnas; i++) {
                for (int j = 0; j < filas; j++) {
                    Celda celda = new Celda(i, j); // Crea una nueva celda
                    celda.setMinSize((double) a/columnas , (double) b/filas); //Tamaño mínimo para visualización
                    celda.setMaxSize((double) a/columnas , (double) b/filas);
                    celda.setStyle("-fx-background-color: #d866f7;-fx-border-color: black; -fx-text-alignment: center;");

                    tableroDeJuego.add(celda, i, j);
                    listaceldas.add(celda);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al crear el tablero.");
            e.printStackTrace();
        }
    }

    public void crearTableroConCeldas(ArrayList<Celda> listaceldas, int columnas, int filas) {
        try {
            double a = paneTablero.getWidth();
            double b = paneTablero.getHeight();

            for (int i = 0; i < columnas; i++) {
                for (int j = 0; j < filas; j++) {
                    Celda celda = getCeldaenDireccion(i,j);
                    celda.setMinSize((double) a / columnas, (double) b / filas); //Tamaño mínimo para visualización
                    celda.setMaxSize((double) a / columnas, (double) b / filas);
                    celda.setStyle("-fx-background-color: #d866f7;-fx-border-color: black; -fx-text-alignment: center;");

                    tableroDeJuego.add(celda, celda.getColumna(), celda.getFila());
                }
            }
        } catch (Exception e) {
            System.err.println("Error al crear el tablero con celdas.");
            e.printStackTrace();
        }
    }

    public void eliminarTablero() {
        try {
            tableroDeJuego.getChildren().clear();
        } catch (Exception e) {
            System.err.println("Error al crear el tablero con celdas.");
            e.printStackTrace();
        }
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////FUNCIONES ALEATORIAS/////////////////////////////////////////////////////////////////////////////////////////////////////
                                        //AgregarIndividuosAleatorios
                                        //AgregarRecursosAleatorios

    public void agregarIndividuosAleatoriosACeldas(int cantidadMaximaIndividuos) {
        try {
            Random random = new Random();

            for (Celda celda : listaceldas) {
                int cantidadIndividuos = random.nextInt(cantidadMaximaIndividuos) + 1; // Genera un número aleatorio de individuos para esta celda
                // Ponemos +1 para asegurarnos de que haya un individuo por lo menos

                // Agrega la cantidad de individuos aleatorios generados a esta celda
                for (int i = 0; i < cantidadIndividuos; i++) {

                    int tipoIndividuo = random.nextInt(3);
                    Individuo nuevoIndividuo = null; //creamos el individuo fuera de los if primero

                    if (tipoIndividuo == 0) {
                        nuevoIndividuo = new IndividuoBasico(idIndividuos, 0, model.getOriginal().getTurnosVida(),
                                0.01 * model.getOriginal().getProbReprod(), 0.01 * model.getOriginal().getProbClon(),
                                1 - (0.01 * model.getOriginal().getProbClon()), 0);
                        idIndividuos++;
                    } else if (tipoIndividuo == 1) {
                        nuevoIndividuo = new IndividuoNormal(idIndividuos, 0, model.getOriginal().getTurnosVida(),
                                0.01 * model.getOriginal().getProbReprod(), 0.01 * model.getOriginal().getProbClon(),
                                1 - (0.01 * model.getOriginal().getProbClon()), 1);
                        idIndividuos++;
                    } else if (tipoIndividuo == 2) {
                        nuevoIndividuo = new IndividuoAvanzado(idIndividuos, 0, model.getOriginal().getTurnosVida(),
                                0.01 * model.getOriginal().getProbReprod(), 0.01 * model.getOriginal().getProbClon(),
                                1 - (0.01 * model.getOriginal().getProbClon()), 2);
                        idIndividuos++;
                    }

                    if (nuevoIndividuo != null) {
                        celda.agregarIndividuo(nuevoIndividuo);
                    } else {
                        throw new NullPointerException("Error al crear un nuevo individuo.");
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error al agregar individuos de manera aleatoria.");
            e.printStackTrace();
        }
    }

    public void agregarRecursosAleatoriosACeldas(int cantidadMaximaRecursos) {
        try {
            Random random = new Random();

            for (Celda celda : listaceldas) {
                int cantidadRecursos = random.nextInt(cantidadMaximaRecursos + 1); // Genera un número aleatorio de recursos para esta celda
                // Agrega la cantidad de recursos aleatorios generados a esta celda
                for (int i = 0; i < cantidadRecursos; i++) {

                    int tipoRecurso = random.nextInt(6);
                    Recurso nuevoRecurso = null; //creamos el recurso fuera de los if primero

                    if (tipoRecurso == 0) {
                        nuevoRecurso = new Recurso("Agua", 3);
                    } else if (tipoRecurso == 1) {
                        nuevoRecurso = new Recurso("Com", 3);
                    } else if (tipoRecurso == 2) {
                        nuevoRecurso = new Recurso("Mont", 3);
                    } else if (tipoRecurso == 3) {
                        nuevoRecurso = new Recurso("Tes", 3);
                    } else if (tipoRecurso == 4) {
                        nuevoRecurso = new Recurso("Biblio", 3);
                    } else if (tipoRecurso == 5) {
                        nuevoRecurso = new Recurso("Pozo", 3);
                    }

                    if (nuevoRecurso != null) {
                        celda.agregarRecurso(nuevoRecurso);
                    } else {
                        throw new NullPointerException("Error al crear un nuevo recurso.");
                    }

                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error al agregar recursos de manera aleatoria.");
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //////////////////////////////////////////FUNCIÓN MOSTRAR EN CELDA/////////////////////////////////////////////////////////////////////////////////

    private void mostrarEnCelda(Celda celda, double fontSize) {
        try {
            HBox contenido = new HBox(); // Box para el contenido en general de la celda
            contenido.setAlignment(Pos.CENTER);

            // Box para los individuos a la izquierda
            VBox individuosBox = new VBox();
            individuosBox.setAlignment(Pos.CENTER_LEFT);
            // Meter todos los individuos de la celda
            for (Individuo individuo : celda.getIndividuos()) {
                Label individuoLabel = new Label(individuo.toString());
                individuoLabel.setStyle("-fx-font-size: " + fontSize + "px;");
                individuosBox.getChildren().add(individuoLabel);

            }

            // Box para los recursos a la derecha
            VBox recursosBox = new VBox();
            recursosBox.setAlignment(Pos.CENTER_RIGHT);
            // Meter todos los recursos de la celda
            for (Recurso recurso : celda.getRecursos()) {
                Label recursoLabel = new Label(recurso.toString());
                recursoLabel.setStyle("-fx-font-size: " + fontSize + "px;");
                recursosBox.getChildren().add(recursoLabel);

            }

            contenido.getChildren().clear(); //Eliminar los boxes y labels del anterior turno

            // Agregar los Box de individuos y recursos al Box horizontal
            contenido.getChildren().addAll(individuosBox, recursosBox);

            // Agregar el contenido al tablero en la posición correspondiente
            tableroDeJuego.add(contenido, celda.getColumna(), celda.getFila());

        } catch (Exception e) {
            System.err.println("Error al mostrar celdas.");
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////BOTONES PAUSAR, TERMINAR Y DESHABILITAR///////////////////////////////////////////////////////////////////////////////
    @FXML
    public void onPausarButtonClick() {
        try {
            if (partidapausa){
                reanudarpartida();
            } else {
                pausarpartida();
            }

        } catch (Exception e) {
            System.err.println("Error al pulsar botón pausar/reanudar.");
            e.printStackTrace();
        }
    }

    public void pausarpartida() {
        try {
            log.debug("Partida pausada.");
            partidapausa = true;
            animationTimer.stop();
            botonPausar.setText("Reanudar");
            botonTerminar.setDisable(false);
            deshabilitarSliders(false);

        } catch (Exception e) {
            System.err.println("Error al pulsar botón pausar.");
            e.printStackTrace();
        }
    }

    public void reanudarpartida() {
        try {
            partidapausa = false;
            adaptarVelocidad();

            animationTimer.start();
            botonPausar.setText("Pausar");
            botonTerminar.setDisable(false);
            deshabilitarSliders(true);

        } catch (Exception e) {
            System.err.println("Error al pulsar botón reanudar.");
            e.printStackTrace();
        }
    }

    // Método para guardar un objeto en un archivo JSON
    public static <T> void guardarObjetoEnArchivo(String rutaArchivo, T objeto) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar un objeto desde un archivo JSON
    public static <T> T cargarObjetoDesdeArchivo(String rutaArchivo, Class<T> clase) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, clase);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void onBotonGuardarClick() {
        log.debug("Hemos entrado en onBotonGuardarClick");
        animationTimer.stop();
        partida.setOriginalcopy(model.getOriginal());
        partida.setListaceldas(listaceldas);
        String rutaArchivo = "partida.json";
        log.debug("Seguimos aquí");
        //guardarObjetoEnArchivo(rutaArchivo, partida);
        log.debug("Seguimos aquí 2");
        partida = null;
        model.getOriginal().setcero();
        scene.close();
    }



    public void onTerminarButtonClick() {
        animationTimer.stop();
        partida = null;
        model.getOriginal().setcero();
    }


    @FXML
    private void deshabilitarSlidersTablero (Boolean a) {
        try {
            sliderColumnas.setDisable(a);
            sliderFilas.setDisable(a);
        } catch (Exception e) {
            System.err.println("Error al deshabilitar los sliders del tablero.");
            e.printStackTrace();
        }
    }
    @FXML
    private void deshabilitarSliders (Boolean a) {
        try {
            sliderVelocidad.setDisable(a);
            sliderTurnosVida.setDisable(a);
            sliderProbReprod.setDisable(a);
            sliderProbClon.setDisable(a);
            sliderAgua.setDisable(a);
            sliderComida.setDisable(a);
            sliderMontaña.setDisable(a);
            sliderTesoro.setDisable(a);
            sliderBiblioteca.setDisable(a);
            sliderPozo.setDisable(a);
            sliderProbNuevoRecurso.setDisable(a);
            sliderProbAgua.setDisable(a);
            sliderProbComida.setDisable(a);
            sliderProbMontaña.setDisable(a);
            sliderProbTesoro.setDisable(a);
            sliderProbBiblioteca.setDisable(a);
            sliderProbPozo.setDisable(a);

        } catch (Exception e) {
            System.err.println("Error al deshabilitar sliders.");
            e.printStackTrace();
        }
    }

    public void onBotonNormasClick() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PantallaNormas.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 705.0, 592.0);
            stage.setTitle("¿CÓMO JUGAR? ");
            stage.setScene(scene);
            //stage.setMaximized(true);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.err.println("Error al abrir las normas del juego.");
            e.printStackTrace();
        }
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////












/**
    @FXML
    public void aceptarParIndividuo(){
        crearPartida();
    }

    @FXML
    public void aceptarParEntorno() {

    }

    @FXML
    public void aceptarTablero() {
        this.tableroCreado = true;
        eliminarTablero();       //Limpiar tablero anterior y volver a dibujarlo
        crearTablero((int) model.getOriginal().getColumnas(), (int) model.getOriginal().getFilas());
        cambiarVelocidad();
    }



 @FXML
 void cambiarVelocidad() {
 if (sliderVelocidad.getValue()==0.25) {
 this.velocidad = 125;
 } else if (sliderVelocidad.getValue()==0.5) {
 this.velocidad = 100;
 } else if (sliderVelocidad.getValue()==0.75) {
 this.velocidad = 75;
 } else if (sliderVelocidad.getValue()==1.25) {
 this.velocidad = 40;
 } else if (sliderVelocidad.getValue()==1.5) {
 this.velocidad = 30;
 } else if (sliderVelocidad.getValue()==1.75) {
 this.velocidad = 20;
 } else if (sliderVelocidad.getValue()==2) {
 this.velocidad = 10;
 } else {
 this.velocidad = 50;
 }
 }


            AnimationTimer animationTimer = new AnimationTimer() {
                int i = velocidad;
                @Override
                public void handle(long now) {
                    if (velocidad == 0) {
                        listaIndividuos = partida.getListaIndividuos();
                        partida.modificarTurno();

                        lblTurno.setText("Turno: " + partida.getTurno);
                    }
                    i++;
                }
            };

    //FUNCIONES MENÚ --OBJETIVO: Dar al usuario las opciones de:
    //                       -CargarPartidaExistente -GuardarPartidaActual -Salir a la Pantalla de Inicio
    @FXML
    public void cargarPartida() {controladorEscenarios.cargarEscenarioCargar();}

    @FXML
    public void salir() { controladorEscenarios.cargarEscerioInicio();}

    @FXML
    private void pause() {
        btnPause.setDisable(true);
        btnEnd.setDisable(false);
        btnStart.setDisable(false);
        deshabilitarSliders(false);
        animationTimer.stop();
    }

    @FXML
    private void endGame() {
        btnEnd.setDisable(true);
        btnPause.setDisable(true);
        btnStart.setDisable(true);
        deshabilitarSliders(true);
        animationTimer.stop();
    }



    @FXML
    private void start() {
        if (tableroCreado) {
            if (!partidaCreada){
                crearPartida();
                partida.individuosInicio();
                listaIndividuos = partida.getListaIndividuos();
                mostrarEnCasilla();
                partidaCreada = true;
            }
            btnStart.setDisable(true);
            btnPause.setDisable(false);
            btnEnd.setDisable(false);
            deshabilitarSliders(true);

            animationTimer.start();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No has creado el tablero");
            alert.showAndWait();
        }
    }

    public void setControladorEscenarios(EscenariosController controlador) {
        this.controladorEscenarios = controlador;
    }

    public void crearPartida() {
        this.partida = new Partida((int) sliderProbReprod.getValue(),(int)sliderProbClon.....)
    }

    public void mostrarEnCasilla() {
        for (Individuo individuo: listaIndividuos) {

                for(Casilla lugar : listaceldas) {
                    if (Objects.equals(celda.getId, lugar.getId())) {
                        lugar.setCenter(circulo);
                    }
                }

            }else {
                circulo.setStroke(Color.rgb(169,250,70));
                circulo.setStrike
                Casilla casilla = .getCasilla()
                for(Casilla lugar : listaceldas) {
                    if (Objects.equals(celda.getId, lugar.getId())) {
                        lugar.setCenter(circulo);
                    }
                }
    }**/


    /**private class Partida extends AnimationTimer {

     private long velocidad = 50;
     private long interval = 1000000000/velocidad;

     private long last = 0;
     @Override
     public void handle(long now) {
     if (now - last > interval) {
     moveryActualizarIndividuos();
     for (Celda celda : listaceldas) {
     double fontSize = Math.min(tableroDeJuego.getWidth() / model.getOriginal().getColumnas(),
     tableroDeJuego.getHeight() / model.getOriginal().getFilas()) / 6;
     mostrarEnCelda(celda, fontSize);
     }
     last = now;
     }
     }
     }**/


































    /**public void crearCeldas(int altura, int ancho) {
        for (int fila = 0; fila < altura; fila++) {
            for (int columna = 0; columna < ancho; columna++) {
                Celda celda = new Celda(fila, columna); // Crea una nueva celda
                listaceldas.add(celda);
            }
        }
    }**/

    /**public void moveryActualizarIndividuos(){
        for (Celda celda : listaceldas) {
            List<Integer> direcciones = null;
            Celda celdanueva = null;
            for (Individuo individuo : celda.getIndividuos()) {
                if (individuo instanceof IndividuoBasico) {
                    IndividuoBasico individuoBasico = (IndividuoBasico) individuo;
                    direcciones = individuoBasico.moveIB(model.getOriginal().getAltura(), model.getOriginal().getAncho());
                    celda.quitarIndividuo(individuoBasico);
                    celdanueva = getCeldaenDireccion(direcciones.get(0), direcciones.get(1));
                    celdanueva.agregarIndividuo(individuoBasico);
                } //else if (individuo instanceof IndividuoNormal) {
                    //IndividuoNormal individuoNormal = (IndividuoNormal) individuo;
                //}

                individuo.actualizar();

            }
        }
    }

    public void actualizarRecursos(){
        for (Celda celda : listaceldas){
            for (Recurso recurso : celda.getRecursos()) {
                recurso.actualizar();
                if (recurso.getTiempoAparicion() == 0) {
                    celda.quitarRecurso(recurso);
                }
            }
        }
    }

    public void ajustarIndividuoARecursos(Celda celda, Individuo individuo) {
        for (Recurso recurso : celda.getRecursos()) {
            if (recurso.getTipo() == "Agua") {
                individuo.setTurnosVida(individuo.getTurnosVida() + model.getOriginal().getAgua());
            } else if (recurso.getTipo() == "Comida") {
                individuo.setTurnosVida(individuo.getTurnosVida() + model.getOriginal().getComida());
            } else if (recurso.getTipo() == "Montaña") {
                individuo.setTurnosVida(individuo.getTurnosVida() + model.getOriginal().getMontaña());
            } else if (recurso.getTipo() == "Tesoro") {
                individuo.setProbReprod(individuo.getProbReprod() + 0.01 * model.getOriginal().getTesoro());
            } else if (recurso.getTipo() == "Biblioteca") {
                individuo.setProbClon(individuo.getProbClon() + 0.01 * model.getOriginal().getBiblioteca());
            } else if (recurso.getTipo() == "Pozo") {
                celda.quitarIndividuo(individuo);
            }
        }
    }

    public Celda getCeldaenDireccion(int columna, int fila) {
        for (Celda celda : listaceldas) {
            if (celda.getColumna() == columna && celda.getFila() == fila) {
                return celda;
            }
        }
        return null;
    }






    **/






















    /**public void agregarIndividuosAleatoriosACeldas2(int cantidadMaximaIndividuos) {
        Random random = new Random();

        // Itera sobre todas las celdas del tablero
        for (int fila = 0; fila < model.getOriginal().getAltura(); fila++) {
            for (int columna = 0; columna < model.getOriginal().getAncho(); columna++) {
                Celda celda = new Celda(fila, columna); // Crea una nueva celda
                int cantidadIndividuos = random.nextInt(cantidadMaximaIndividuos) + 1; // Genera un número aleatorio de individuos para esta celda
                // Ponemos +1 para asegurarnos de que haya un individuo por lo menos

                // Agrega la cantidad de individuos aleatorios generados a esta celda
                for (int i = 0; i < cantidadIndividuos; i++) {

                    int tipoIndividuo = random.nextInt(3);
                    Individuo nuevoIndividuo = null; //creamos el individuo fuera de los if primero

                    if (tipoIndividuo == 0) {
                        nuevoIndividuo = new IndividuoBasico(0, 0,model.getOriginal().getTurnosVida(),
                                0.01 * model.getOriginal().getProbReprod(), 0.01 * model.getOriginal().getProbClon(),
                                1 - (0.01 * model.getOriginal().getProbClon()));
                    } else if (tipoIndividuo == 1) {
                        nuevoIndividuo = new IndividuoNormal(1, 0, model.getOriginal().getTurnosVida(),
                                0.01 * model.getOriginal().getProbReprod(), 0.01 * model.getOriginal().getProbClon(),
                                1 - (0.01 * model.getOriginal().getProbClon()));
                    } else if (tipoIndividuo == 2) {
                        nuevoIndividuo = new IndividuoAvanzado(2, 0, model.getOriginal().getTurnosVida(),
                                0.01 * model.getOriginal().getProbReprod(), 0.01 * model.getOriginal().getProbClon(),
                                1 - (0.01 * model.getOriginal().getProbClon()));
                    }

                    celda.agregarIndividuo(nuevoIndividuo); // Agrega el individuo a la celda
                }

                // Agrega la celda con los individuos generados al tablero de juego
                listaceldas.add(celda);
            }
        }
    }**/


    /**public void agregarRecursosAleatoriosACeldas2(int cantidadMaximaRecursos) {
        Random random = new Random();


        for (int fila = 0; fila < model.getOriginal().getAltura(); fila++) {
            for (int columna = 0; columna < model.getOriginal().getAncho(); columna++) {
                Celda celda = new Celda(fila, columna); // Crea una nueva celda
                int cantidadIndividuos = random.nextInt(cantidadMaximaRecursos) + 1; // Genera un número aleatorio de individuos para esta celda
                // Ponemos +1 para asegurarnos de que haya un individuo por lo menos

                // Agrega la cantidad de recursos aleatorios generados a esta celda
                for (int i = 0; i < cantidadIndividuos; i++) {

                    int tipoIndividuo = random.nextInt(6);
                    Recurso recurso = null; //Creamos el recurso fuera de los if primero


                }

            }
        }
    }**/


    /** Nota 1: IMPORTANTE:
     * la inicialización en este caso la hemos hecho cuando el usuario ha pulsado el botón.
     * También podríamos hacerla en el método "initialize" si indicamos que el controlador es "Initializable",
     * como en los ejemplos anteriores.
     */

    /** Nota 2:
     * Este ejemplo está hecho para reducir al máximo la complejidad, pero hay que recordar que podríamos querer
     * enlazar lo que aparece en cada celda del grid con objetos y properties...
     */

    /** Nota 3:
     * Si quiero varios elementos en la misma celda, debo introducirlos en un layout y ese layour meterlo en la celda.
     */








}
