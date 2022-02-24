module mggcode.menudinamico {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;
    requires retrofit2;
    requires retrofit2.converter.gson;

    opens mggcode.menudinamico to javafx.fxml;
    opens mggcode.menudinamico.entity;
    opens mggcode.menudinamico.rest;
    exports mggcode.menudinamico;
    exports mggcode.menudinamico.entity;
    exports mggcode.menudinamico.rest;
}