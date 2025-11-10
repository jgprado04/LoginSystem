module br.loginsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.loginsystem to javafx.fxml;
    exports br.loginsystem;
}