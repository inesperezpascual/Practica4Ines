package es.uah.metod.practica4ines;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class MainApplication extends Application {

    public static final Logger log = LogManager.getLogger(MainApplication.class);

    @Override
    public void start(Stage stage) throws IOException {
        log.info("Inicio del arranque de la ventana del menú inicial");
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("menu-inicial.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 340);
        stage.setTitle("Menú Inicial");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}