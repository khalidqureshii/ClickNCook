module com.example.mpr2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.mpr2 to javafx.fxml;
    exports com.example.mpr2;
}