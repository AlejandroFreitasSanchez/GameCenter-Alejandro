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
public class MusicController implements Initializable {

    @FXML
    private Button load1;
    @FXML
    private Button load2;
    @FXML
    private Button load3;
    @FXML
    private Button load4;
    @FXML
    private Button goBackbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void load1(ActionEvent event) {
        //carga la siguiente cancion , para el media player y llama al metodo music de App
        App.setMusic("src/main/resources/Music&Images/ambience.mp3");
        App.getPlayer().stop();
        App.music();
    }

    @FXML
    private void load2(ActionEvent event) {
        //carga la siguiente cancion , para el media player y llama al metodo music de App
         App.setMusic("src/main/resources/Music&Images/cinematic.mp3");
        App.getPlayer().stop();
        App.music();
    }

    @FXML
    private void load3(ActionEvent event) {
        //carga la siguiente cancion , para el media player y llama al metodo music de App
         App.setMusic("src/main/resources/Music&Images/mindfulnes.mp3");
        App.getPlayer().stop();
        App.music();
    }

    @FXML
    private void load4(ActionEvent event) {
        //carga la siguiente cancion , para el media player y llama al metodo music de App
        App.setMusic("src/main/resources/Music&Images/final.mp3");
        App.getPlayer().stop();
        App.music();
    }

    @FXML
    private void volverAtras(ActionEvent event) throws IOException {
        //vuelve a la pagina center
        App.setRoot("center");
        
        
    }
    
}
