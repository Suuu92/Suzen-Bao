module com.example.librarysystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires derby;


    opens com.suzen.librarysystem to javafx.fxml;
    exports com.suzen.librarysystem;
}