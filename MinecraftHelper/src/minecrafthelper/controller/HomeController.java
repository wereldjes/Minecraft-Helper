package minecrafthelper.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Dominique
 */
public class HomeController implements Initializable {
    
    @FXML
    private Button showBlocks;
    @FXML
    private Button jsonLoader;
    @FXML
    private Button closeApp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBlocks.setOnAction(event -> showAllBlocks());
        jsonLoader.setOnAction(event -> loadJson());
        closeApp.setOnAction(event->close());
    }
    
    @FXML
    public void loadJson() {
        JsonReader reader = new JsonReader();
        reader.getJsonData("https://minecraft-ids.grahamedgecombe.com/items.json");
    }
    
    @FXML
    public void showAllBlocks() {
        Stage stage= (Stage) showBlocks.getScene().getWindow();
        BlockScreenController bsc = new BlockScreenController(stage);
    }
    
    @FXML
    public void close(){
        Stage stage = (Stage)closeApp.getScene().getWindow();
        stage.close();
    }
}
