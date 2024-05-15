module com.example.appconversao {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.appconversao to javafx.fxml;
    exports com.example.appconversao;
}