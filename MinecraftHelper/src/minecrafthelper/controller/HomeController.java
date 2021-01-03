package minecrafthelper.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author Dominique
 */
public class HomeController implements Initializable {
    
    @FXML
    private Button jsonLoader;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jsonLoader.setOnAction(event -> loadJson());
    }
    
    @FXML
    public void loadJson() {
        JsonReader reader = new JsonReader();
        reader.getJsonData("https://minecraft-ids.grahamedgecombe.com/items.json");
    }
    
}
