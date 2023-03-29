module com.example.practica {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.json;
    requires java.sql;

    opens com.example.practica to javafx.fxml;
    exports com.example.practica;
}