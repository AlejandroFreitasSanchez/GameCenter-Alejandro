/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gamecenter;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author freit
 */
public class EditCategoryController implements Initializable {
      private Game c;
    @FXML
    private TextField nameField;
    @FXML
    private Button sendButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField descField;
    @FXML
    private TextField priceField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void enviar(ActionEvent event) throws IOException {
          if (c != null) {
            //recoge los datos de los texfield y los mete a los atributos del juego
            c.setName(nameField.getText());
            c.setDescripcion(descField.getText());
            c.setPrecio(priceField.getText());
            //vuelve a la libreria
            App.setRoot("library");
        }else{
            this.c=new Game();
            this.c.setName(nameField.getText());
            Aplicacion.getInstance().addGame(c);
        }
    }
    
    


    public Game getC() {
        return c;
    }

    public void setC(Game c) {
        this.c = c;
        this.nameField.setText(this.c.getName());
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        //vuelve a la libreria
        App.setRoot("library");
    }
    
}
