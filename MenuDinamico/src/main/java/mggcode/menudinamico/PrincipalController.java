package mggcode.menudinamico;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import mggcode.menudinamico.entity.Persona;
import mggcode.menudinamico.rest.APIRestConfig;
import mggcode.menudinamico.rest.AccesoDatosRest;
import retrofit2.Response;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {
    private final AccesoDatosRest restService = APIRestConfig.getService();
    private ObservableList<Persona> personas;

    @FXML
    private DetalleController detalleController;

    @FXML
    private GraficoController graficoController;

    @FXML
    private ListView<Persona> lista;

    @FXML
    private HBox contenedor;

    @FXML
    private GridPane grid;

    @FXML
    private ImageView imageAjustes, imageAudio, imageContactos, imageHome;

    @FXML
    private Pane panel;

    @FXML
    private StackPane detalle, grafico;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        detalle.setVisible(false);
        grafico.setVisible(false);
        panel.setVisible(false);

        personas = cargarPersonas();
        graficoController.cargarDatosPieChart(personas);
        personas.forEach(x -> System.out.println(x.getName()));

        lista.setItems(personas);
        lista.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lista.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                detalleController.mostrarDetalle(new Image("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"), newValue.getName(), newValue.getUsername(),
                        newValue.getPhone(), newValue.getEmail());
                detalle.setVisible(true);
                grafico.setVisible(true);
            }
        });
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
        if (grid.getTranslateX() == -75) {
            grid.setTranslateX(grid.getTranslateX() + 75);
            panel.setTranslateX(grid.getTranslateX() + 175);
            panel.setVisible(true);
        } else {
            grid.setTranslateX(-75.0);
            panel.setVisible(false);
            if (event.getSource().equals(imageHome)) {
                volverAlMenu();
            }
            if (event.getSource().equals(imageAudio)) {
                volverAlMenu();
            }
            if (event.getSource().equals(imageContactos)) {
                lista.setVisible(true);
                detalle.setVisible(true);
                grafico.setVisible(true);
            }

            if (event.getSource().equals(imageAjustes)) {
                volverAlMenu();
            }

        }
    }

    private void volverAlMenu() {
        if (detalle.isVisible()) {
            detalle.setVisible(false);
        }
        if (grafico.isVisible()) {
            grafico.setVisible(false);
        }
        if (lista.isVisible()) {
            lista.setVisible(false);
        }
    }
}
