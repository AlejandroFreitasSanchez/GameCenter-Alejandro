package com.mycompany.gamecenter;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField userField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    

    @FXML
    private void loguear(ActionEvent event) throws IOException {
        //si el nombre y la contraseña coincide cambia de pagina
        if(this.userField.getText().equalsIgnoreCase("user") && this.passwordField.getText().equalsIgnoreCase("user")){
            App.setRoot("center");
        }
    }
}
