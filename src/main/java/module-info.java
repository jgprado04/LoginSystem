module br.loginsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;


    opens br.loginsystem to javafx.fxml;
    exports br.loginsystem;
}