module poo2.login.views  {
    requires javafx.controls;
    requires javafx.fxml;

    opens poo2.login.views to javafx.fxml;
    opens poo2.login.controllers to javafx.fxml;
    exports poo2.login.views; 
}
