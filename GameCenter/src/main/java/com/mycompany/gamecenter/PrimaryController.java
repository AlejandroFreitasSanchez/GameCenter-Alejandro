package com.mycompany.gamecenter;

import com.mycompany.model.Aplicacion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
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
    private Button closeMSGbutton;
    @FXML
    private DialogPane msg;
    
    

    @FXML
    private void loguear(ActionEvent event) throws IOException {
        //si el nombre y la contraseña coincide cambia de pagina
        if(this.userField.getText().equalsIgnoreCase("user") && this.passwordField.getText().equalsIgnoreCase("user")){
            App.setRoot("center");
        }else{
            this.msg.setVisible(true);
        }
    }

    @FXML
    private void closeMSG(ActionEvent event) {
        this.msg.setVisible(false);
    }
}
