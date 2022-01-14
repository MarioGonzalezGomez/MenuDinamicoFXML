module mggcode.menudinamico {
    requires javafx.controls;
    requires javafx.fxml;


    opens mggcode.menudinamico to javafx.fxml;
    exports mggcode.menudinamico;
}