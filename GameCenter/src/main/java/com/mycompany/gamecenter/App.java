package com.mycompany.gamecenter;

import com.mycompany.model.Aplicacion;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Duration;
import static sun.audio.AudioPlayer.player;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;
    //path de la musica que viene por defecto
     private static String music="src/main/resources/Music&Images/cinematic.mp3";
     private static  MediaPlayer player;
     private Aplicacion a;
    
    
   
    @Override
    public void start(Stage stage) throws IOException {
        //metodo musica
        this.music();
        scene = new Scene(loadFXML("login"), 1300, 900);
        //bloquea el tamaño de la ventana para que no pueda ajustarse con el raton
        stage.setResizable(false);
        
        stage.setScene(scene);
        
        
        
        stage.show();
        
      
   
       
    }
    
    public static void music(){
       
        //inicializa la musica
        Media m= new Media(Paths.get(getMusic()).toUri().toString());
        setPlayer(new MediaPlayer(m));
        getPlayer().play();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * @return the music
     */
    public static String getMusic() {
        return music;
    }

    /**
     * @param music the music to set
     */
    public static void setMusic(String music) {
        App.music = music;
    }

    /**
     * @return the player
     */
    public static MediaPlayer getPlayer() {
        return player;
    }

    /**
     * @param aPlayer the player to set
     */
    public static void setPlayer(MediaPlayer aPlayer) {
        player = aPlayer;
    }

  public static Window getWindows(){
      return App.scene.getWindow();
  }
   
    

}