/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gamecenter;

import com.mycompany.gamecenter.App;
import com.mycompany.model.Aplicacion;
import com.mycompany.model.Game;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author freit
 */
public class AddGameController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField descField;
    @FXML
    private TextField priceField;
    @FXML
    private Button sendButton;
    @FXML
    private Button goBackButton;
    private Aplicacion p;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.p = Aplicacion.getInstance();
    }    

    @FXML
    private void enviar(ActionEvent event) throws IOException {
        //crea un nuevo juego, pasa los datos de los textfield a sus atributos y los mete al arraylist de juegos que tiene Aplicacion
        Game c=new Game();
        c.setName(this.nameField.getText());
        c.setId(p.getCategorias().size());
        c.setDescripcion(this.descField.getText());
        c.setPrecio(this.priceField.getText());
        p.addGame(c);
        //vuelve a libreria
        App.setRoot("library");
        
    }

    @FXML
    private void volverAtras(ActionEvent event) throws IOException {
        //vuelve a libreria
        App.setRoot("library");
    }
    
}
