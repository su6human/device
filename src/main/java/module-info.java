module com.example.device {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.device to javafx.fxml;
    exports com.example.device;
}