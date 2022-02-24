package mggcode.menudinamico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

import java.util.ResourceBundle;

public class App extends Application {
    private ResourceBundle resourceBundle;

    @Override
    public void start(Stage stage) throws IOException {
        Locale locale = new Locale("es", "ES");
        Locale locale2 = new Locale("en", "UK");
        resourceBundle = ResourceBundle.getBundle("mggcode.i18n.strings", locale);
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("principal.fxml"), resourceBundle);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Interfaz Dinamica");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}