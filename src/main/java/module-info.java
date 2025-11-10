module br.loginsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens br.loginsystem to javafx.fxml;
    exports br.loginsystem;
}