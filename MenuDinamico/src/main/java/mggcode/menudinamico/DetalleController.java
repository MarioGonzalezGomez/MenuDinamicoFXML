package mggcode.menudinamico;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import org.kordamp.ikonli.javafx.FontIcon;


public class DetalleController {

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

    public void mostrarDetalle(Image image,String nombre, String apellido, String telefono, String email) {
        ivUser.setImage(image);
        lblFirstName.setText(nombre);
        lblLastName.setText(apellido);
        lblEmail.setText(email);
        lblPhone.setText(telefono);
    }

}