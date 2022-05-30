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
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author freit
 */
public class OptionsController implements Initializable {

    @FXML
    private Button rescale1;
    @FXML
    private Button rescale2;
    @FXML
    private Button rescale3;
    @FXML
    private Button rescale4;
    @FXML
    private Button goBackbutton;
    @FXML
    private Pane panel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setRescale1(ActionEvent event) {
        //cambia la posicion de los nodos y el tamaño del panel
        this.panel.getChildren().get(2).relocate(50, 20);
        this.panel.getChildren().get(0).relocate(150, 50);
        this.panel.getChildren().get(1).relocate(50, 120);
        this.panel.setPrefWidth(640);
        this.panel.setPrefHeight(480);
            
    }

    @FXML
    private void setRescale2(ActionEvent event) {
    //cambia la posicion de los nodos y el tamaño del panel
    this.panel.getChildren().get(2).relocate(50, 20);
    this.panel.getChildren().get(0).relocate(150, 50);
    this.panel.getChildren().get(1).relocate(80, 90);
    this.panel.setPrefWidth(860);
    this.panel.setPrefHeight(540);
        
    }

    @FXML
    private void setRescale3(ActionEvent event) {
        //cambia la posicion de los nodos y el tamaño del panel
        this.panel.getChildren().get(2).relocate(100, 40);
        this.panel.getChildren().get(0).relocate(350, 70);
        this.panel.getChildren().get(1).relocate(160, 110);
        this.panel.setPrefWidth(1300);
        this.panel.setPrefHeight(900);
    }

    @FXML
    private void setRescale4(ActionEvent event) {
            //cambia la posicion de los nodos y el tamaño del panel
            this.panel.getChildren().get(2).relocate(120, 40);
            this.panel.getChildren().get(0).relocate(370, 70);
            this.panel.getChildren().get(1).relocate(280, 210);
            this.panel.setPrefWidth(1920);
            this.panel.setPrefHeight(1080);
         
    }

    @FXML
    private void volverAtras(ActionEvent event) throws IOException {
        //vuelve a la pagina center
        App.setRoot("center");
    }
    
}
