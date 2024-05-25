package es.uah.metod.practica4ines;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
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

    @FXML Label labelFinJuego = new Label();

    private ArrayList<Celda> listaceldas = new ArrayList<>();

    private boolean partidapausa;

    @FXML
    private Button botonPausar;

    @FXML
    private Button botonTerminar;

    private int idIndividuos = 0;
    private int idRecursos = 0;
    private int velocidadAdaptadaANIMATION = 50;

    @FXML
    private Label labelTurno;
    private int turnoPartida = 1;
    private boolean partidaComenzada = false;

    @FXML
    private Button botonJugar;

    protected double fontSize;


    private Partida partida = new Partida();

    /** Radio botones para que el usuario añada individuos/recursos al tablero **/

    @FXML
    private ToggleGroup group = new ToggleGroup();

    @FXML
    private RadioButton añadirIndividuoBasico;
    @FXML
    private RadioButton añadirIndividuoNormal;
    @FXML
    private RadioButton añadirIndividuoAvanzado;
    @FXML
    private RadioButton añadirAgua;
    @FXML
    private RadioButton añadirComida;
    @FXML
    private RadioButton añadirMontaña;
    @FXML
    private RadioButton añadirTesoro;
    @FXML
    private RadioButton añadirBiblioteca;
    @FXML
    private RadioButton añadirPozo;














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




    //////////////////////////FUNCIONES PARA HACER INTERCONECTAR LOS ELEMENTOS VISUALES///////////////////////////////////////////////////////////
    public void bindSlidersLabelsInteger(Slider slider, Label label, IntegerProperty medida) {
        slider.valueProperty().bindBidirectional(medida);
        label.textProperty().bind(medida.asString());
    }

    public void bindSlidersLabelsDouble(Slider slider, Label label, DoubleProperty medida) {
        slider.valueProperty().bindBidirectional(medida);
        label.textProperty().bind(medida.asString());
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Métodos de configuración
     **/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        log.debug("Inicialización en ejecución del controlador de parámetros\n");

        paneTablero.getChildren().addAll(tableroDeJuego, labelFinJuego);
        tableroDeJuego.setGridLinesVisible(true);
        botonJugar.setDisable(true);
        botonPausar.setDisable(true);

        //Metemos todos los RadioButtons en el mismo
        añadirIndividuoBasico.setToggleGroup(group);
        añadirIndividuoNormal.setToggleGroup(group);
        añadirIndividuoAvanzado.setToggleGroup(group);
        añadirAgua.setToggleGroup(group);
        añadirComida.setToggleGroup(group);
        añadirMontaña.setToggleGroup(group);
        añadirTesoro.setToggleGroup(group);
        añadirBiblioteca.setToggleGroup(group);
        añadirPozo.setToggleGroup(group);

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

        log.debug("Hemos conectado los datos del modelo con el GUI");
    }

    /**
     * Este método recibe los datos del modelo y los establece
     **/
    public void loadUserData(ParameterDataModelProperties parametrosData) {
        this.model = parametrosData;
        this.updateGUIwithModel();
        log.debug("Hemos establecido el ParameterDataModelProperties y hemos conectado sus datos con el GUI");
    }

    public void setStage(Stage s){
        this.scene = s;
    }


    @FXML
    protected void onJugarButtonClick() {
        try {
            partidaComenzada = true;
            log.debug("Ha comenzado la partida");
            welcomeText.setText("Que comience el juego!");
            System.out.println("Hemos llegado al tablero");

            partidapausa = false;
            deshabilitarSliders(true);
            deshabilitarSlidersTablero(true);
            botonJugar.setDisable(true);
            botonPausar.setDisable(false);


            eliminarTablero();

            crearTablero(model.getOriginal().getColumnas(), model.getOriginal().getFilas());

            agregarRecursosAleatoriosACeldas(3);
            agregarIndividuosAleatoriosACeldas(3);


            fontSize = Math.min(paneTablero.getWidth() / model.getOriginal().getColumnas(),
                    paneTablero.getHeight() / model.getOriginal().getFilas()) / 6;

            log.debug("Vamos a imprimir el tablero 1");

            for (Celda celda : listaceldas) {
                mostrarEnCelda(celda, fontSize);
            }
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
    /** Esta clase se encarga de ir actualizando los individuos y el entorno y que se vaya reproduciendo automáticamente por turnos**/


    AnimationTimer animationTimer = new AnimationTimer() {
        int i = velocidadAdaptadaANIMATION;
        @Override
        public void handle(long now) {
            try {
                if (i == 0) {
                    turnoPartida++;
                    log.debug("Turno" + turnoPartida);
                    labelTurno.setText("Turno: " + turnoPartida);
                    i = velocidadAdaptadaANIMATION;
                    moverIndividuos();
                    actualizarIndividuos();
                    actualizarRecursos();
                    evaluarReproducir();
                    evaluarClonacion();
                    evaluarMorirIndividuos();
                    evaluarMorirRecursos();

                    ArrayList<Celda> celdascopy = new ArrayList<>();
                    for (Celda celda : listaceldas) {
                        celdascopy.add(celda);
                    }
                    evaluarterminarPartida();
                    eliminarTablero();
                    listaceldas = celdascopy;
                    fontSize = Math.min(paneTablero.getWidth() / model.getOriginal().getColumnas(),
                            paneTablero.getHeight() / model.getOriginal().getFilas()) / 6;

                    log.debug("Vamos a imprimir el tablero " + turnoPartida);
                    crearTableroConCeldas(listaceldas, model.getOriginal().getColumnas(), model.getOriginal().getFilas());
                    for (Celda celda : listaceldas) {
                        mostrarEnCelda(celda, fontSize);
                    }
                }
                i--;

            } catch (Exception e) {
                // Manejo de la excepción: muestra un mensaje de error al usuario
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                log.error("Se produjo un error durante la animación.");
                alert.setHeaderText("Se produjo un error durante la animación");
                alert.setContentText("Detalles del error: " + e.getMessage());
                alert.showAndWait();
            }
        }
    };


    void adaptarVelocidad() {
        /**La velocidad del Animation Timer es realmente elevada, por lo que creamos un bucle al que no le
         permitimos entrar hasta que no lo haga una cierta cantidad de veces **/
        log.debug("Se va a adaptar la velocidad");

        try {
            if (model.getOriginal().getVelocidad()==0.25) {
                this.velocidadAdaptadaANIMATION = 150;
            } else if (model.getOriginal().getVelocidad()==0.5) {
                this.velocidadAdaptadaANIMATION = 100;
            } else if (model.getOriginal().getVelocidad()==0.75) {
                this.velocidadAdaptadaANIMATION = 80;
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
            log.error("El modelo original es nulo.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error: Se produjo una excepción no esperada.");
            log.error("Se produjo una excepción no esperada.");
            e.printStackTrace();
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //////////////////////////////////FUNCION PARA MOVER INDIVIDUOS ENTRE LAS CELDAS/////////////////////////////////////////////////

    public void moverIndividuos(){
        for (Celda celda : listaceldas) {
            List<Individuo> individuoscopy = new ArrayList<>(celda.getIndividuos());

            for (Individuo individuo : individuoscopy) {
                List<Integer> direcciones = null;
                Celda celdaDestino = null;

                if (individuo.getTipo() == 0) {
                    IndividuoBasico individuoBasico = (IndividuoBasico) individuo;
                    direcciones = individuoBasico.moveIB(model.getOriginal().getColumnas(), model.getOriginal().getFilas());
                    celda.quitarIndividuo(individuoBasico);
                    celdaDestino = getCeldaenDireccion(direcciones.get(0), direcciones.get(1));
                    celdaDestino.agregarIndividuo(individuoBasico);
                    for (Recurso recurso : celdaDestino.getRecursos()) {
                        ajustarIndividuoARecurso(recurso, individuoBasico);
                    }

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
                        celdaDestino = celdasConRecursosLineaRecta.get(random.nextInt(celdasConRecursosLineaRecta.size()));

                        celda.quitarIndividuo(individuo);
                        celdaDestino.agregarIndividuo(individuo);
                        for (Recurso recurso : celdaDestino.getRecursos()) {
                            ajustarIndividuoARecurso(recurso, individuo);
                        }
                    }
                }
            }
        }
        log.debug("Hemos movido los individuos");
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    //////////////////////////////////////////FUNCION EVALUAR QUIEN DEBE MORIR (SIZE>3) ///////////////////////////////////////////////////////////////////////

    public void evaluarMorirIndividuos() {
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
            log.debug("Hemos evaluado si hay más de 3 individuos por celda y cuáles deben morir en ese caso");

        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas o de individuos.");
            log.error("Se encontró una referencia nula en la lista de celdas o de individuos.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error: Se produjo una excepción no esperada al evaluar morir.");
            log.error("Se produjo una excepción no esperada al evaluar morir.");
            e.printStackTrace();
        }
    }


    public void evaluarMorirRecursos() {
        try {
            for (Celda celda : listaceldas) {
                List<Recurso> recursoslista = celda.getRecursos();
                Collections.sort(recursoslista, Comparator.comparingInt(Recurso::getTiempoAparicion));
                while (recursoslista.size() > 3) {
                    Iterator<Recurso> iterator = recursoslista.iterator();

                    iterator.next();
                    iterator.remove();
                }
            }
            log.debug("Hemos evaluado si hay más de 3 individuos por celda y cuáles deben morir en ese caso");

        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas o de individuos.");
            log.error("Se encontró una referencia nula en la lista de celdas o de individuos.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error: Se produjo una excepción no esperada al evaluar morir.");
            log.error("Se produjo una excepción no esperada al evaluar morir.");
            e.printStackTrace();
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    //////////////////////////////////////////////////////////FUNCIONES REPRODUCCION///////////////////////////////////////////////////////////////////////////


    public void evaluarReproducir(){
        /** Une las probabilidades de reproducción de ambos individuos, si es mayor a 0.5 se llama a la función reproducir **/

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
            log.debug("Hemos evaluado si todos los individuos de cada celda se deben reproducir");

        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas o de individuos.");
            log.error("Se encontró una referencia nula en la lista de celdas o de individuos.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error al evaluar la reproducción.");
            log.error("Error al evaluar la reproducción.");
            e.printStackTrace();
        }
    }

    public void reproducir (Individuo individuo1, Individuo individuo2, Celda celda) {
        /** Se reproducen dos individuos, teniendo en cuenta sus niveles, y se mete su hijo en la celda **/

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
                nuevoIndividuo = new IndividuoBasico(idIndividuos, turnoPartida,model.getOriginal().getTurnosVida(),
                        model.getOriginal().getProbReprod(), model.getOriginal().getProbClon(),
                        1 - (model.getOriginal().getProbReprod()), 0);
            } else if (creartipo == 1) {
                nuevoIndividuo = new IndividuoNormal(idIndividuos, turnoPartida, model.getOriginal().getTurnosVida(),
                        model.getOriginal().getProbReprod(), model.getOriginal().getProbClon(),
                        1 - (model.getOriginal().getProbReprod()), 1);
            } else if (creartipo == 2) {
                nuevoIndividuo = new IndividuoAvanzado(idIndividuos, turnoPartida, model.getOriginal().getTurnosVida(),
                        model.getOriginal().getProbReprod(), model.getOriginal().getProbClon(),
                        1 - (model.getOriginal().getProbReprod()), 2);
            }


            if (nuevoIndividuo != null) {
                celda.agregarIndividuo(nuevoIndividuo);
                for (Recurso recurso : celda.getRecursos()) {
                    ajustarIndividuoARecurso(recurso,nuevoIndividuo);
                }
                idRecursos ++;
            } else {
                log.error("Error al crear un nuevo individuo.");
                throw new NullPointerException("Error al crear un nuevo individuo.");
            }
        } catch (Exception e) {
            System.err.println("Error al reproducir dos individuos.");
            log.error("Error al reproducir dos individuos.");
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////EVALUAR CLONACIÓN//////////////////////////////////////////////////////////////////////////////////////////

    public void evaluarClonacion(){
        /** Para cada individuo se genera un número aleatorio(entre 0 y 1), y si es menor que la probabilidad
         de clonación se crea un individuo exactamente igual(distinto id)**/

        try {
            for (Celda celda : listaceldas) {

                List<Individuo> individuoscopy = new ArrayList<>(celda.getIndividuos());
                for (Individuo individuo : individuoscopy) {
                    double randomProbabilidad = Math.random();
                    if (randomProbabilidad < individuo.getProbClon()) {
                        Individuo nuevoIndividuo = null;
                        if (individuo.getTipo() == 0){
                            nuevoIndividuo = new IndividuoBasico(idIndividuos, turnoPartida, individuo.getTurnosVida(), individuo.getProbReprod(),
                                    individuo.getProbClon(), individuo.getProbMuerte(), 0);
                        } else if (individuo.getTipo() == 1) {
                            nuevoIndividuo = new IndividuoNormal(idIndividuos, turnoPartida, individuo.getTurnosVida(), individuo.getProbReprod(),
                                    individuo.getProbClon(), individuo.getProbMuerte(), 1);
                        } else if (individuo.getTipo() == 2) {
                            nuevoIndividuo = new IndividuoAvanzado(idIndividuos, turnoPartida, individuo.getTurnosVida(), individuo.getProbReprod(),
                                    individuo.getProbClon(), individuo.getProbMuerte(), 2);
                        }

                        if (nuevoIndividuo != null) {
                            celda.agregarIndividuo(nuevoIndividuo);
                            idRecursos ++;
                            log.debug("Hemos clonado un individuo");
                        } else {
                            log.error("Error al crear un nuevo individuo.");
                            throw new NullPointerException("Error al crear un nuevo individuo.");
                        }
                    }
                }
            }
            log.debug("Hemos evaluado que individuos deben clonarse");

        } catch (Exception e) {
            log.error("Error al reproducir dos individuos.");
            System.err.println("Error al reproducir dos individuos.");
            e.printStackTrace();
        }
    }


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
            log.debug("Hemos actualizado los individuos");

        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas o de individuos.");
            log.error("Se encontró una referencia nula en la lista de celdas o de individuos.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error al actualizar individuos.");
            log.error("Error al actualizar individuos.");
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

                        Recurso nuevoRecurso = new Recurso(idRecursos, (String) tipoo, 3);

                        if (nuevoRecurso != null) {
                            celda.agregarRecurso(nuevoRecurso);
                            idRecursos ++;
                            for (Individuo individuo : celda.getIndividuos()) {
                                ajustarIndividuoARecurso(nuevoRecurso, individuo);
                            }
                        } else {
                            log.error("Error al crear un nuevo recurso.");
                            throw new NullPointerException("Error al crear un nuevo recurso.");
                        }
                    }
                }
            }
            log.debug("Hemos actualizado los recursos");

        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas o de individuos.");
            log.error("Se encontró una referencia nula en la lista de celdas o de individuos.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error al actualizar recursos.");
            log.error("Error al actualizar recursos.");
            e.printStackTrace();
        }
    }

    public void ajustarIndividuoARecurso(Recurso recurso, Individuo individuo) {

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
            individuo.setProbClon(individuo.getProbClon() + 0.005 * model.getOriginal().getPozo());
        }
        log.debug("Hemos ajustado los individuos a los recursos que hay en su nueva celda.");
    }



    //////////////////////////////////////////Función que devuelve la Celda de las direcciones que especificas////////////////////////////////////////
    public Celda getCeldaenDireccion(int columna, int fila) {
        try {
            /** Busca celda por celda hasta encontrar la celda con la misma columna y fila **/

            for (Celda celda : listaceldas) {
                if (celda.getColumna() == columna && celda.getFila() == fila) {
                    return celda;
                }
            }
            return null;
        } catch (NullPointerException e) {
            log.error("Error: Se encontró una referencia nula en la lista de celdas.");
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas.");
            e.printStackTrace();
            return null;

        } catch (Exception e) {
            log.error("Error al buscar celda en dirección.");
            System.err.println("Error al buscar celda en dirección.");
            e.printStackTrace();
            return null;
        }

    }

    //////////////////////////////////////////////CUENTA NÚMERO DE VIVOS EN TOTAL/////////////////////////////////////////////////////////
    public int numerovivos() {
        /** Celda por celda, por cada individuo añade uno más la variable "vivos" **/
        int vivos = 0;
        for (Celda celda : listaceldas) {
            for (Individuo individuo : celda.getIndividuos()) {
                vivos ++;
            }
        }
        return vivos;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////TERMINAR PARTIDA//////////////////////////////////////////////////////////////////////////////////////////

    public void evaluarterminarPartida(){
        /** En cada turno(AnimationTimer) se llama a esta función para comprobar si se debe finalizar la partida.
         Si se debe finalizar se llama a la función terminarPartida();
         **/
        if (numerovivos() == 1){
            terminarPartida();
        }
        log.debug("Hemos evaluado si se debe terminar la partida.");
    }

    public void terminarPartida(){

        /** Impríme un mensaje al finalizar la partida (dándole al botón Terminar o cuando solo queda un individuo vivo) **/

        animationTimer.stop();
        labelFinJuego.setMinSize(paneTablero.getHeight(),paneTablero.getWidth());
        fontSize = Math.min(paneTablero.getWidth(), paneTablero.getHeight() ) / 10;
        labelFinJuego.setStyle("-fx-font-size: " + fontSize + "px;" +" -fx-text-alignment: center;");
        labelFinJuego.setText("¡¡¡ GRACIAS POR JUGAR !!!");

        log.debug("Hemos terminado la partida y hemos impreso un mensaje por pantalla.");
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

                    celda.setOnMouseClicked(event -> clickonCelda(event,celda));

                    tableroDeJuego.add(celda, i, j);
                    listaceldas.add(celda);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al crear el tablero.");
            log.error("Error al crear el tablero.");
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

                    celda.setOnMouseClicked(event -> clickonCelda(event,celda));

                    tableroDeJuego.add(celda, celda.getColumna(), celda.getFila());
                }
            }
        } catch (Exception e) {
            System.err.println("Error al crear el tablero con celdas.");
            log.error("Error al crear el tablero con celdas.");
            e.printStackTrace();
        }
    }

    public void eliminarTablero() {
        try {
            tableroDeJuego.getChildren().clear();
            log.debug("Hemos eliminado el tablero.");
        } catch (Exception e) {
            System.err.println("Error al crear el tablero con celdas.");
            log.error("Error al crear el tablero con celdas.");
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

                    } else if (tipoIndividuo == 1) {
                        nuevoIndividuo = new IndividuoNormal(idIndividuos, 0, model.getOriginal().getTurnosVida(),
                                0.01 * model.getOriginal().getProbReprod(), 0.01 * model.getOriginal().getProbClon(),
                                1 - (0.01 * model.getOriginal().getProbClon()), 1);

                    } else if (tipoIndividuo == 2) {
                        nuevoIndividuo = new IndividuoAvanzado(idIndividuos, 0, model.getOriginal().getTurnosVida(),
                                0.01 * model.getOriginal().getProbReprod(), 0.01 * model.getOriginal().getProbClon(),
                                1 - (0.01 * model.getOriginal().getProbClon()), 2);

                    }

                    if (nuevoIndividuo != null) {
                        celda.agregarIndividuo(nuevoIndividuo);
                        idIndividuos++;
                        for (Recurso recurso : celda.getRecursos()) {
                            ajustarIndividuoARecurso(recurso, nuevoIndividuo);
                        }
                    } else {
                        throw new NullPointerException("Error al crear un nuevo individuo.");
                    }
                }
            }
            log.debug("Hemos añadido individuos de forma aleatoria a las celdas.");

        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas.");
            log.error("Se encontró una referencia nula en la lista de celdas.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error al agregar individuos de manera aleatoria.");
            log.error("Error al agregar individuos de manera aleatoria.");
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
                        nuevoRecurso = new Recurso(idRecursos,"Agua", 3);
                    } else if (tipoRecurso == 1) {
                        nuevoRecurso = new Recurso(idRecursos,"Com", 3);
                    } else if (tipoRecurso == 2) {
                        nuevoRecurso = new Recurso(idRecursos,"Mont", 3);
                    } else if (tipoRecurso == 3) {
                        nuevoRecurso = new Recurso(idRecursos,"Tes", 3);
                    } else if (tipoRecurso == 4) {
                        nuevoRecurso = new Recurso(idRecursos,"Biblio", 3);
                    } else if (tipoRecurso == 5) {
                        nuevoRecurso = new Recurso(idRecursos,"Pozo", 3);
                    }

                    if (nuevoRecurso != null) {
                        celda.agregarRecurso(nuevoRecurso);
                        idRecursos ++;
                    } else {
                        throw new NullPointerException("Error al crear un nuevo recurso.");
                    }

                }
            }
            log.debug("Hemos añadido recursos de forma aleatoria a las celdas.");

        } catch (NullPointerException e) {
            System.err.println("Error: Se encontró una referencia nula en la lista de celdas.");
            log.error("Se encontró una referencia nula en la lista de celdas.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("Error al agregar recursos de manera aleatoria.");
            log.error("Error al agregar recursos de manera aleatoria.");
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


            contenido.setOnMouseClicked(event -> clickonCelda(event, celda));

            celda.getChildren().add(contenido);

            // Agregar el contenido al tablero en la posición correspondiente
            tableroDeJuego.add(contenido, celda.getColumna(), celda.getFila());

            //log.debug("Hemos mostrado las celdas por pantalla con su contenido.");

        } catch (Exception e) {
            System.err.println("Error al mostrar celdas.");
            log.error("Error al mostrar celdas.");
            e.printStackTrace();
        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////FUNCIONES USUARIO AÑADA INDIVIDUOS/RECURSOS//////////////////////////////////////////////////////////////



    public void clickonCelda(MouseEvent event, Celda celda) {

        log.debug("Se ha pulsado en la celda.");
        log.debug(celda.getColumna());
        log.debug(celda.getFila());
        log.debug("Estamos en clickonCelda");

        fontSize = Math.min(paneTablero.getWidth() / model.getOriginal().getColumnas(),
                paneTablero.getHeight() / model.getOriginal().getFilas()) / 6;

        if (añadirIndividuoBasico.isSelected()) {
            añadirIndivBasicoCelda(celda, fontSize);
        } else if (añadirIndividuoNormal.isSelected()) {
            añadirIndivNormalCelda(celda, fontSize);
        } else if (añadirIndividuoAvanzado.isSelected()) {
            añadirIndivAvanzadoCelda(celda, fontSize);
        } else if (añadirAgua.isSelected()) {
            añadirAguaCelda(celda, fontSize);
        } else if (añadirComida.isSelected()) {
            añadirComidaCelda(celda, fontSize);
        } else if (añadirMontaña.isSelected()) {
            añadirMontañaCelda(celda, fontSize);
        } else if (añadirTesoro.isSelected()) {
            añadirTesoroCelda(celda, fontSize);
        } else if (añadirBiblioteca.isSelected()) {
            añadirBiblitecaCelda(celda, fontSize);
        } else if (añadirPozo.isSelected()) {
            añadirPozoCelda(celda, fontSize);
        }
    }

    public void cambiarTablero(ArrayList<Celda> listaceldas, double fontSize) {
        ArrayList<Celda> celdascopy = new ArrayList<>();
        for (Celda casilla : listaceldas) {
            celdascopy.add(casilla);
        }

        eliminarTablero();
        log.debug("Hemos eliminado el tablero");
        listaceldas = celdascopy;

        evaluarterminarPartida();
        evaluarMorirIndividuos();
        evaluarMorirRecursos();
        crearTableroConCeldas(listaceldas, model.getOriginal().getColumnas(), model.getOriginal().getFilas());
        for (Celda casilla : listaceldas) {
            mostrarEnCelda(casilla, fontSize);
        }
    }


    public void añadirIndivBasicoCelda (Celda celda, double fontSize) {

        IndividuoBasico nuevoIndividuo = new IndividuoBasico(idIndividuos, turnoPartida, model.getOriginal().getTurnosVida(),
                0.01 * model.getOriginal().getProbReprod(), 0.01 * model.getOriginal().getProbClon(),
                1 - (0.01 * model.getOriginal().getProbClon()), 0);
        log.debug("Hemos creado el individuo básico");

        if (nuevoIndividuo != null) {

            celda.agregarIndividuo(nuevoIndividuo);
            idIndividuos++;
            for (Recurso recurso : celda.getRecursos()) {
                ajustarIndividuoARecurso(recurso, nuevoIndividuo);
            }

            cambiarTablero(listaceldas, fontSize);
        } else {
            log.error("Error al crear un nuevo individuo básico.");
            throw new NullPointerException("Error al crear un nuevo individuo básico.");
        }

    }


    public void añadirIndivNormalCelda (Celda celda, double fontSize) {

        IndividuoNormal nuevoIndividuo = new IndividuoNormal(idIndividuos, turnoPartida, model.getOriginal().getTurnosVida(),
                0.01 * model.getOriginal().getProbReprod(), 0.01 * model.getOriginal().getProbClon(),
                1 - (0.01 * model.getOriginal().getProbClon()), 1);

        if (nuevoIndividuo != null) {
            celda.agregarIndividuo(nuevoIndividuo);
            idIndividuos++;
            for (Recurso recurso : celda.getRecursos()) {
                ajustarIndividuoARecurso(recurso, nuevoIndividuo);
            }
            cambiarTablero(listaceldas, fontSize);
        } else {
            log.error("Error al crear un nuevo individuo normal.");
            throw new NullPointerException("Error al crear un nuevo individuo normal.");
        }

    }

    public void añadirIndivAvanzadoCelda (Celda celda, double fontSize) {

        IndividuoAvanzado nuevoIndividuo = new IndividuoAvanzado(idIndividuos, turnoPartida, model.getOriginal().getTurnosVida(),
                0.01 * model.getOriginal().getProbReprod(), 0.01 * model.getOriginal().getProbClon(),
                1 - (0.01 * model.getOriginal().getProbClon()), 1);

        if (nuevoIndividuo != null) {
            celda.agregarIndividuo(nuevoIndividuo);
            idIndividuos++;
            for (Recurso recurso : celda.getRecursos()) {
                ajustarIndividuoARecurso(recurso, nuevoIndividuo);
            }
            cambiarTablero(listaceldas, fontSize);
        } else {
            log.error("Error al crear un nuevo individuo avanzado.");
            throw new NullPointerException("Error al crear un nuevo individuo avanzado.");
        }

    }

    public void añadirAguaCelda (Celda celda, double fontSize) {

        Recurso nuevoRecurso = new Recurso(idRecursos, "Agua", 3);

        if (nuevoRecurso != null) {
            celda.agregarRecurso(nuevoRecurso);
            idRecursos ++;
            for (Individuo individuo : celda.getIndividuos()) {
                ajustarIndividuoARecurso(nuevoRecurso, individuo);
            }
            cambiarTablero(listaceldas, fontSize);
        } else {
            log.error("Error al crear un nuevo recurso (agua).");
            throw new NullPointerException("Error al crear un nuevo recurso (agua).");
        }

    }

    public void añadirComidaCelda (Celda celda, double fontSize) {

        Recurso nuevoRecurso = new Recurso(idRecursos, "Com", 3);

        if (nuevoRecurso != null) {
            celda.agregarRecurso(nuevoRecurso);
            idRecursos ++;
            for (Individuo individuo : celda.getIndividuos()) {
                ajustarIndividuoARecurso(nuevoRecurso, individuo);
            }
            cambiarTablero(listaceldas, fontSize);
        } else {
            log.error("Error al crear un nuevo recurso (comida).");
            throw new NullPointerException("Error al crear un nuevo recurso (comida).");
        }

    }

    public void añadirMontañaCelda (Celda celda, double fontSize) {

        Recurso nuevoRecurso = new Recurso(idRecursos, "Mont", 3);

        if (nuevoRecurso != null) {
            celda.agregarRecurso(nuevoRecurso);
            idRecursos ++;
            for (Individuo individuo : celda.getIndividuos()) {
                ajustarIndividuoARecurso(nuevoRecurso, individuo);
            }
            cambiarTablero(listaceldas, fontSize);
        } else {
            log.error("Error al crear un nuevo recurso (montaña).");
            throw new NullPointerException("Error al crear un nuevo recurso (montaña).");
        }

    }

    public void añadirTesoroCelda (Celda celda, double fontSize) {

        Recurso nuevoRecurso = new Recurso(idRecursos, "Tes", 3);

        if (nuevoRecurso != null) {
            celda.agregarRecurso(nuevoRecurso);
            idRecursos ++;
            for (Individuo individuo : celda.getIndividuos()) {
                ajustarIndividuoARecurso(nuevoRecurso, individuo);
            }
            cambiarTablero(listaceldas, fontSize);
        } else {
            log.error("Error al crear un nuevo recurso (tesoro).");
            throw new NullPointerException("Error al crear un nuevo recurso (tesoro).");
        }

    }

    public void añadirBiblitecaCelda (Celda celda, double fontSize) {

        Recurso nuevoRecurso = new Recurso(idRecursos, "Biblio", 3);

        if (nuevoRecurso != null) {
            celda.agregarRecurso(nuevoRecurso);
            idRecursos ++;
            for (Individuo individuo : celda.getIndividuos()) {
                ajustarIndividuoARecurso(nuevoRecurso, individuo);
            }
            cambiarTablero(listaceldas, fontSize);
        } else {
            log.error("Error al crear un nuevo recurso (biblioteca).");
            throw new NullPointerException("Error al crear un nuevo recurso (biblioteca).");
        }

    }

    public void añadirPozoCelda (Celda celda, double fontSize) {

        Recurso nuevoRecurso = new Recurso(idRecursos, "Pozo", 3);

        if (nuevoRecurso != null) {
            celda.agregarRecurso(nuevoRecurso);
            idRecursos ++;
            for (Individuo individuo : celda.getIndividuos()) {
                ajustarIndividuoARecurso(nuevoRecurso, individuo);
            }
            cambiarTablero(listaceldas, fontSize);
        } else {
            throw new NullPointerException("Error al crear un nuevo recurso.");
        }

    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////BOTONES PAUSAR, TERMINAR Y DESHABILITAR///////////////////////////////////////////////////////////////////////////////

    @FXML
    public void onBotonAceptarClick() {
        model.commit(); //En model se guardan todos los datos.
        if (partidaComenzada == false) {
            botonJugar.setDisable(false);
        }
        log.debug("Se ha apretado el botón aceptar.");
    }
    @FXML
    public void onBotonReiniciarClick() {
        model.rollback();
        log.debug("Se ha apretado el botón reiniciar.");
    }

    @FXML
    public void onBotonCerrarClick() {
        animationTimer.stop();
        reiniciarVariablesGenerales();
        scene.close();
        log.debug("Se ha apretado el botón cerrar.");
    }

    public void reiniciarVariablesGenerales() {

        welcomeText.setText("");
        eliminarTablero();
        listaceldas.clear();
        partidapausa = false;
        botonPausar.setDisable(false);
        botonTerminar.setDisable(false);
        botonJugar.setDisable(false);
        idIndividuos = 0;
        idRecursos = 0;
        velocidadAdaptadaANIMATION = 50;
        labelTurno.setText("Turno: ");
        turnoPartida = 1;
        partida = null;
        deshabilitarSliders(false);
        deshabilitarSlidersTablero(false);
        model.getOriginal().setcero();

        log.debug("Se han reiniciado las variables generales.");
    }


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
            log.error("Error al pulsar botón pausar/reanudar.");
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
            log.error("Error al pulsar botón pausar.");
            System.err.println("Error al pulsar botón pausar.");
            e.printStackTrace();
        }
    }

    public void reanudarpartida() {
        try {
            log.debug("Partida reanudada.");
            partidapausa = false;
            adaptarVelocidad();

            animationTimer.start();
            botonPausar.setText("Pausar");
            botonTerminar.setDisable(false);
            deshabilitarSliders(true);

        } catch (Exception e) {
            log.error("Error al pulsar botón reanudar.");
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
            log.error("Error al guardar el objeto en el archivo");
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
            log.error("Error al cardar objeto desde el archivo.");
            return null;
        }
    }

    public void onBotonGuardarClick() {
        log.debug("Se ha apretado el botón Guardar.");
        animationTimer.stop();
        partida.setOriginalcopy(model.getOriginal());
        partida.ordenarEnListas(listaceldas);
        partida.setIdIndividuos(idIndividuos);
        partida.setIdRecursos(idRecursos);
        partida.setTurnoPartida(turnoPartida);
        String rutaArchivo = "partida.json";
        guardarObjetoEnArchivo(rutaArchivo, partida);
    }

    public void cargarPartida() {
        log.debug("Se está cargando una partida antigua.");
        String rutaArchivo = "partida.json";
        Partida partida = cargarObjetoDesdeArchivo(rutaArchivo, Partida.class);

        listaceldas.clear();
        partida.desordenarEnListas(listaceldas);
        model.setOriginal(partida.getOriginalcopy());
        idIndividuos = partida.getIdIndividuos();
        idRecursos = partida.getIdRecursos();
        turnoPartida = partida.getTurnoPartida();

        partidaComenzada = true;
        botonPausar.setText("Reanudar");
        botonPausar.setDisable(false);
        deshabilitarSlidersTablero(true);

    }



    public void onTerminarButtonClick() {
        log.debug("Se ha apretado el botón terminar partida.");
        terminarPartida();
        reiniciarVariablesGenerales();

    }


    @FXML
    private void deshabilitarSlidersTablero (Boolean a) {
        try {
            sliderColumnas.setDisable(a);
            sliderFilas.setDisable(a);
            log.debug("Se han deshabilitado los sliders del tablero.");
        } catch (Exception e) {
            System.err.println("Error al deshabilitar los sliders del tablero.");
            log.error("Error al deshabilitar los sliders del tablero.");
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

            log.debug("Se han deshabilitado los sliders generales.");

        } catch (Exception e) {
            System.err.println("Error al deshabilitar sliders.");
            log.error("Error al deshabilitar sliders.");
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
            log.debug("Se ha abierto una ventana con las normas.");
        } catch (Exception e) {
            System.err.println("Error al abrir las normas del juego.");
            log.error("Error al abrir las normas del juego.");
            e.printStackTrace();
        }
    }



}
