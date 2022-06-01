/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.xml.bind.JAXBException;

/**
 *
 * @author freit
 */
public class Aplicacion {
      private ObservableList<Game> categorias;
     
      
    private static Aplicacion instance;
    static{
        instance=null;
    }
    private Aplicacion() {
         this.categorias = FXCollections.observableArrayList();
     
       
       // this.categorias = new HashMap<>();
    }
    public static Aplicacion getInstance(){
        if(instance==null){
            instance= new Aplicacion();
            instance.init();
            
        }
        return instance;
            
    }
    
    private void init() {
        Game c;
        //Juegos por defecto de la aplicacion
        c = new Game();
        c.setId(1);
        c.setName("Lol");
        c.setDescripcion("League of Legends es un videojuego del género multijugador de arena de batalla en línea y deporte electrónico el cual fue desarrollado por Riot Games para Microsoft Windows y OS X y para consolas digitales. ");
        c.setPrecio("Free");
        c.setPath("\"C:\\Riot Games\\League of Legends\\LeagueClient.exe\"");
       
        this.addGame(c);
       
        c = new Game();
        c.setId(2);
        c.setName("Call of Duty");
        c.setDescripcion("Call of Duty es una serie de videojuegos de disparos en primera persona");
        c.setPrecio("60");
        c.setPath("\"C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe\"");
        this.addGame(c);

        c = new Game();
        c.setId(3);
        c.setName("Dota");
        c.setDescripcion("Dota 2 es un videojuego perteneciente al género de Arena de batalla en línea ARTS, también conocido como MOBA");
        c.setPrecio("Free");
        c.setPath("a");
        this.addGame(c);
            
        c= new Game();
        c.setId(4);
        c.setName("the binding of isacc");
        c.setDescripcion("The Binding of Isaac es un juego de acción RPG con fuertes elementos de tipo Roguelike, en el cual los niveles son generados aleatoriamente");
        c.setPrecio("25");
        c.setPath("\"C:\\Users\\freit\\Dropbox\\Mi PC (DESKTOP-4DJBEG0)\\Desktop\\The.Binding.of.Isaac.Rebirth.v1.7.8a\\The.Binding.of.Isaac.Rebirth.v1.7.8a\\Game\\isaac-ng.exe\"");
       this.addGame(c);
        
          
    }
    //devuelve los juegos
    public ObservableList<Game> getGame() {
        return this.getCategorias();
    }
    //añadir juego al arraylist
    public void addGame(Game c) {    
        this.getCategorias().add( c);
    }
    //borra un juego 
    public Game removeCategory(Game c){
        return this.getCategorias().remove(c.getId());
    }
    //borra un juego por id
    public boolean removeCategory(Integer id){
        return this.getCategorias().removeIf(e-> e.getId()==id);
    }
    //te devuelve un juego
    public Game getCategory(Integer id) {
        return this.getCategorias().get(id);
    }

    /**
     * @return the categorias
     */
    public ObservableList<Game> getCategorias() {
        return categorias;
    }

    /**
     * @param categorias the categorias to set
     */
    public void setCategorias(ObservableList<Game> categorias) {
        this.categorias = categorias;
    }
   
    
}
