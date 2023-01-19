module com.example.adro {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;
    //requires com.almasb.fxgl.all;

    opens com.example.adro to javafx.fxml;
    exports com.example.adro;
}