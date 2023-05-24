module com.example.guiproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.guiproject to javafx.fxml;
    exports com.example.guiproject;
}