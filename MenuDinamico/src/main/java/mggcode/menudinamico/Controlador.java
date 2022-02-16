package mggcode.menudinamico;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import mggcode.menudinamico.entity.Persona;
import mggcode.menudinamico.rest.APIRestConfig;
import mggcode.menudinamico.rest.AccesoDatosRest;
import retrofit2.Response;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controlador implements Initializable {
    AccesoDatosRest restService = APIRestConfig.getService();

    @FXML
    private ListView<Persona> lista;
    private ObservableList<Persona> personas;

    @FXML
    private HBox listaDetalle;

    @FXML
    private ImageView imageAjustes;

    @FXML
    private ImageView imageAudio;

    @FXML
    private ImageView imageContactos;

    @FXML
    private ImageView imageHome;

    @FXML
    private VBox vBox;

    @FXML
    private Pane panel;

    @FXML
    private StackPane detalle;

    @FXML
    private StackPane grafico;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaDetalle.setVisible(false);
        listaDetalle.setTranslateX(-100);
        personas = cargarPersonas();
        if (personas == null) {
            System.out.println("Por qué está vacia??");
        }
        lista.setItems(personas);
        lista.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    private ObservableList<Persona> cargarPersonas() {
        List<Persona> noObservable = getPersonas();
        if (noObservable != null) {
            return FXCollections.observableArrayList(noObservable);
        } else {
            return null;
        }
    }

    private List<Persona> getPersonas() {
        try {
            Response<List<Persona>> response = restService.personasGetAll().execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            } else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @FXML
    void desplegarMenu(MouseEvent event) {
        if (vBox.getTranslateX() == -50) {
            vBox.setTranslateX(vBox.getTranslateX() + 50);
            panel.setTranslateX(vBox.getTranslateX());
            panel.setVisible(true);
        } else {
            vBox.setTranslateX(-50.0);
            panel.setVisible(false);
            if (event.getSource().equals(imageHome)) {
                //  lbl1.setVisible(true);
                //  lbl2.setVisible(false);
                //  lbl3.setVisible(false);
                //  lbl4.setVisible(false);
            }
            if (event.getSource().equals(imageAudio)) {
                // lbl1.setVisible(false);
                // lbl2.setVisible(true);
                // lbl3.setVisible(false);
                // lbl4.setVisible(false);
            }
            if (event.getSource().equals(imageContactos)) {
                //  lbl1.setVisible(false);
                //  lbl2.setVisible(false);
                //  lbl3.setVisible(true);
                //  lbl4.setVisible(false);
            }

            if (event.getSource().equals(imageAjustes)) {
                //  lbl1.setVisible(false);
                //  lbl2.setVisible(false);
                //  lbl3.setVisible(false);
                //  lbl4.setVisible(true);
            }

        }
    }
}
