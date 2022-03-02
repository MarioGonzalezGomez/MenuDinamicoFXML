package mggcode.menudinamico;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;
import java.util.ResourceBundle;


public class DetalleController implements Initializable {

    @FXML
    private StackPane detalle;

    @FXML
    private FontIcon salirDetalle;

    @FXML
    private ImageView ivUser;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblLastName;

    public void mostrarDetalle(Image image, String nombre, String apellido, String telefono, String email) {
        ivUser.setImage(image);
        lblFirstName.setText(nombre);
        lblLastName.setText(apellido);
        lblEmail.setText(email);
        lblPhone.setText(telefono);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        salirDetalle.setOnMouseClicked(mouseEvent -> detalle.setVisible(false));
    }
}