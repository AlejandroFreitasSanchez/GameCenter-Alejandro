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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author freit
 */
public class LibraryController implements Initializable {

    @FXML
    private Button addCategoryButton;
    @FXML
    private Button goBackButton;
    @FXML
    private TableView<Game> tabla_categorias;
    @FXML
    private TableColumn<Game, Integer> c_id;
    @FXML
    private TableColumn<Game, String> c_nombre;
    @FXML
    private TableColumn<Game, Void> c_editar;
    @FXML
    private TableColumn<Game, Void> c_borrar;
    private Aplicacion p;
    private ObservableList<Game> categorias;
    @FXML
    private AnchorPane contenedor;
    @FXML
    private TableColumn<Game, String> c_descripcion;
    @FXML
    private TableColumn<Game, String> c_precio;
    @FXML
    private TableColumn<Game, Void> c_ejecutar;
    @FXML
    private TextField searchField;
    @FXML
    private DialogPane msg;
    @FXML
    private Button closeMsg;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.p = Aplicacion.getInstance();

        this.configTable();
        this.initTable();
    }    

    @FXML
    private void addCategory(ActionEvent event) throws IOException {
        App.setRoot("addGame");
    }

    @FXML
    private void volverAtras(ActionEvent event) throws IOException {
        App.setRoot("center");
    }
      private void initTable() {
        
          //FilteredList para poder buscar por nombre y mete a la lista los juegos que la clase Aplicacion tiene en su array
          FilteredList<Game> juegos= new FilteredList(p.getGame(), p -> true);
          //Se añade el filteredList al TableView
          this.tabla_categorias.setItems(juegos);
          //Se configura la busqueda
          searchField.textProperty().addListener((prop, old, text) -> {
            juegos.setPredicate(a -> {
        if(text == null || text.isEmpty()) return true;
        
        String name = a.getName().toLowerCase();
        return name.contains(text.toLowerCase());
    });
});

    }

    private void configTable() {

        //para que pinte el valor de tipo cadena
        this.c_nombre.setCellValueFactory(c -> {
            return new ObservableValueBase<String>() {
                @Override
                public String getValue() {
                    return c.getValue().getName();
                }
            };
        });

        this.c_id.setCellValueFactory(c -> {
            return new ObservableValueBase<Integer>() {
                @Override
                public Integer getValue() {
                    return c.getValue().getId();
                }

            };
        });
          this.c_descripcion.setCellValueFactory(c -> {
            return new ObservableValueBase<String>() {
                @Override
                public String getValue() {
                    return c.getValue().getDescripcion();
                }

            };
        });
           this.c_precio.setCellValueFactory(c -> {
            return new ObservableValueBase<String>() {
                @Override
                public String getValue() {
                    return c.getValue().getPrecio();
                }

            };
        });
        
        //devuelve una celda personalizada
        this.c_editar.setCellFactory(categorytablecell -> {
            return new TableCell<Game, Void>() {
                private final Button btn = new Button("Editar");
                //similar al constructor por defecto

                {
                    btn.setOnAction((ActionEvent event) -> {

                        contenedor.getChildren().clear();
                        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("editCategory.fxml"));
                        try {
                            Parent t = fxmlLoader.load();
                            EditCategoryController sc = fxmlLoader.getController();
                            sc.setC((Game) getTableRow().getItem());
                            contenedor.getChildren().add(t);

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                }

                /*
                    Se encarga de pintar el botón
                 */
                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            };

        });

        this.c_borrar.setCellFactory((m) -> {
            //clase anónima creada para esto
            return new TableCell<Game, Void>() {
                private final Button btn = new Button("Borrar");

                {
                    btn.setOnAction((ActionEvent event) -> {
                        Game data = getTableView().getItems().get(getIndex());
                        p.removeCategory(data.getId());
                        tabla_categorias.setItems(FXCollections.observableArrayList(p.getGame()));
                        tabla_categorias.refresh();
                    });
                }

                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }

            };
        });
       
         
         this.c_ejecutar.setCellFactory(categorytablecell -> {
            return new TableCell<Game, Void>() {
                private final Button btn = new Button("Ejecutar");
                //similar al constructor por defecto

                {
                     btn.setOnAction((ActionEvent event) -> {
                        Game data = getTableView().getItems().get(getIndex());
                        Runtime obj = Runtime.getRuntime();
                         try { 
                             obj.exec(data.getPath());
                         } catch (IOException ex) {
                             System.out.println("El path del juego es incorrecto o no esta instalado");
                             msg.setVisible(true);
                             

                         }
                        
                        
                    });
                }

                /*
                    Se encarga de pintar el botón
                 */
                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            };

        });
         
       


    }

    private void listado(MouseEvent event) {
        this.contenedor.getChildren().clear();
        this.tabla_categorias.refresh();
        this.contenedor.getChildren().add(this.tabla_categorias);
    }

    public void onChanged(ListChangeListener.Change<? extends Game> change) {
        this.tabla_categorias.refresh();
    }

    private void nuevo(MouseEvent event) throws IOException {
        contenedor.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("editCategory.fxml"));

        Parent t = fxmlLoader.load();
        EditCategoryController sc = fxmlLoader.getController();

        contenedor.getChildren().add(t);
    }

    private void searchGame(ActionEvent event) throws IOException {
        App.setRoot("buscador");
    }

    @FXML
    private void cerrarMSG(ActionEvent event) {
        msg.setVisible(false);
    }

    
    
}
