package mggcode.menudinamico;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import mggcode.menudinamico.entity.Persona;
import org.kordamp.ikonli.javafx.FontIcon;


public class GraficoController {

    @FXML
    private StackPane grafico;
    @FXML
    private PieChart nombres;
    @FXML
    private FontIcon salirGrafico;


    int largos = 0;
    int cortos = 0;
    int medianos = 0;

    public void salirDeGrafico() {
        salirGrafico.setOnMouseClicked(mouseEvent -> grafico.setVisible(false));
    }

    public void cargarDatosPieChart(ObservableList<Persona> lista) {
        lista.stream().map(Persona::getName).forEach(x -> {
            if (x.length() <= 12) {
                cortos += 1;
            } else if (x.length() <= 14) {
                medianos += 1;
            } else {
                largos += 1;
            }
        });

        ObservableList<PieChart.Data> datosGraficoCircular = FXCollections.observableArrayList(
                new PieChart.Data("Cortos", cortos),
                new PieChart.Data("Medianos", medianos),
                new PieChart.Data("Largos", largos));

        nombres.setData(datosGraficoCircular);
        nombres.setClockwise(false);
        nombres.setTitle("Longitud de nombres");
    }
}
