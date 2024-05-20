package es.uah.metod.practica4ines;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController  {
    @FXML
    private Label welcomeText;


    /** Modelo de datos **/

    private ParameterDataModel parametrosData = new ParameterDataModel(0, 0,1,0,0,0,
                                                                    0,0,0,0,0,0,0,
                                                                    0,0,0,0,0,0);
    private ParameterDataModelProperties modeloParaGUICompartido = new ParameterDataModelProperties(parametrosData);

    @FXML
    public void onNuevaPartidaParametrosBotonClick() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("NuevaPartidaParametros.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 420, 340);
            stage.setTitle("Bienvenido: ");
            stage.setScene(scene);
            NuevaPartidaParametrosController p = fxmlLoader.getController();
            p.loadUserData(this.modeloParaGUICompartido); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
            //p.loadUserData(new ParameterDataModelProperties(this.parametrosData));    //Carga un nuevo modelo para cada ventana, por lo que
            //                                                                            si modificas uno no se modifica no se modifica el otro.
            p.setStage(stage);
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    @FXML
    public void onCargarPartidaBotonClick() {
    }

    /** Al no tener nada aparte de los botones
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador\n");
        labelTextoEjemplo.textProperty().bind(texto);
         miSlider.valueProperty().bindBidirectional(medida);
         labelValorSlider.textProperty().bind(medida.asString());
    }
         **/
}