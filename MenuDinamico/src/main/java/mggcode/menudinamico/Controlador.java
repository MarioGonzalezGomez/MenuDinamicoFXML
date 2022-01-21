package mggcode.menudinamico;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controlador implements Initializable {


    @FXML
    private ImageView imageAjustes;

    @FXML
    private ImageView imageAudio;

    @FXML
    private ImageView imageContactos;

    @FXML
    private ImageView imageHome;

    /*
    @FXML private Label lblAjustes;

    @FXML private Label lblAudio;

    @FXML private Label lblContactos;

    @FXML private Label lblHome;
    */

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private VBox vBox;

    @FXML
    void desplegarMenu(MouseEvent event) {
        if (vBox.getTranslateX() == -50) {
            vBox.setTranslateX(vBox.getTranslateX() + 50);
        } else {
            vBox.setTranslateX(-50.0);
            if (event.getSource().equals(imageHome)) {
                lbl1.setVisible(true);
                lbl2.setVisible(false);
                lbl3.setVisible(false);
                lbl4.setVisible(false);
            }
            if (event.getSource().equals(imageAudio)) {
                lbl1.setVisible(false);
                lbl2.setVisible(true);
                lbl3.setVisible(false);
                lbl4.setVisible(false);
            }
            if (event.getSource().equals(imageContactos)) {
                lbl1.setVisible(false);
                lbl2.setVisible(false);
                lbl3.setVisible(true);
                lbl4.setVisible(false);
            }

            if (event.getSource().equals(imageAjustes)) {
                lbl1.setVisible(false);
                lbl2.setVisible(false);
                lbl3.setVisible(false);
                lbl4.setVisible(true);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Locale locale = new Locale("es", "ES");
        Locale locale2 = new Locale("en", "UK");
        resourceBundle = ResourceBundle.getBundle("mggcode.i18n.strings", locale);
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")), resourceBundle);
        } catch (IOException e) {
            e.printStackTrace();
        }
       // Locale.setDefault(locale);
    }
}
