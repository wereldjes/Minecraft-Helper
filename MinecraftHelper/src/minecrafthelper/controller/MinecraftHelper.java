/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minecrafthelper.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Dominique
 */
public class MinecraftHelper extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        HomeController controller = new HomeController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/minecrafthelper/resources/Home.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("Minecraft Helper");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
