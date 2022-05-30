/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gamecenter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author freit
 */
public class CenterController implements Initializable {

    @FXML
    private Button libraryButton;
    @FXML
    private Button optionsButton;
    @FXML
    private Button unloginButton;
    @FXML
    private Button musicPageButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goLibrary(ActionEvent event) throws IOException {
        //va a la libreria
        App.setRoot("library");
    }

    @FXML
    private void goOptions(ActionEvent event) throws IOException {
        //va a opciones
        App.setRoot("options");
    }

    @FXML
    private void desloguearse(ActionEvent event) throws IOException {
        //vuelve al login
        App.setRoot("login");
    }

    @FXML
    private void goMusciSection(ActionEvent event) throws IOException {
        //va a la pagina musica
        App.setRoot(("music"));
    }
    
}
