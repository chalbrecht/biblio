module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.biblio to javafx.fxml;
    opens com.example.biblio.model;
    exports com.example.biblio;
}