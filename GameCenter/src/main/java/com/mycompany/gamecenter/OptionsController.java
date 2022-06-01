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
        //cambia la posicion de los nodos ,el tamaño del panel y la ventana

        App.getWindows().setWidth(640);
        App.getWindows().setHeight(480);
        panel.setPrefSize(650, 480);
        panel.getChildren().get(1).relocate(0, 0);
        panel.getChildren().get(2).relocate(200, 400);
        panel.getChildren().get(0).setVisible(false);
    }

    @FXML
    private void setRescale2(ActionEvent event) {
        //cambia la posicion de los nodos ,el tamaño del panel y la ventana

        App.getWindows().setWidth(960);
        App.getWindows().setHeight(540);
        panel.setPrefSize(960, 540);
        panel.getChildren().get(1).relocate(0, 0);
        panel.getChildren().get(2).relocate(200, 400);
        panel.getChildren().get(0).setVisible(false);

    }

    @FXML
    private void setRescale3(ActionEvent event) {
        //cambia la posicion de los nodos ,el tamaño del panel y la ventana

        App.getWindows().setWidth(1300);
        App.getWindows().setHeight(900);
        panel.setPrefSize(1300, 900);
        panel.getChildren().get(1).relocate(332, 152);
        panel.getChildren().get(2).relocate(332, 600);
        panel.getChildren().get(0).setVisible(true);
    }

    @FXML
    private void setRescale4(ActionEvent event) {
        //cambia la posicion de los nodos ,el tamaño del panel y la ventana

        App.getWindows().setWidth(1920);
        App.getWindows().setHeight(1080);
        panel.setPrefSize(1920, 1080);
        panel.getChildren().get(1).relocate(332, 242);
        panel.getChildren().get(2).relocate(332, 740);
        panel.getChildren().get(0).setVisible(true);
        

    }

    @FXML
    private void volverAtras(ActionEvent event) throws IOException {
        //vuelve a la pagina center
        App.setRoot("center");
    }

}
