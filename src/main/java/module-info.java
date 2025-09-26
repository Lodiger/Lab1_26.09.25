module org.example.lab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab1 to javafx.fxml;
    exports org.example.lab1;
}