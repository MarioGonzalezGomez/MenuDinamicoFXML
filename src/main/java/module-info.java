module com.example.interfazdinamicafxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.interfazdinamicafxml to javafx.fxml;
    exports com.example.interfazdinamicafxml;
}