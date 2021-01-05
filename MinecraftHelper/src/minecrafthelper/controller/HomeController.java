package minecrafthelper.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import minecrafthelper.datalayer.BlockDao;

/**
 *
 * @author Dominique
 */
public class HomeController implements Initializable {
    
    @FXML
    private Button showBlocks;
    @FXML
    private Button deleteData;
    @FXML
    private Button jsonLoader;
    @FXML
    private Button closeApp;
    @FXML
    private StackPane messageDiv;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBlocks.setOnAction(event -> showAllBlocks());
        deleteData.setOnAction(event-> deleteData());
        jsonLoader.setOnAction(event -> loadJson());
        closeApp.setOnAction(event->close());
    }
    
    public HomeController() {

    }
    
    public HomeController(Stage stage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/minecrafthelper/resources/Home.fxml"));
        loader.setController(this);
        Parent root;
        try {
            root = loader.load();
            stage.getScene().setRoot(root);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(BlockScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void loadJson() {
        JsonReader reader = new JsonReader();
        reader.getJsonData("https://minecraft-ids.grahamedgecombe.com/items.json");
        Label message = new Label();
        message.setText("Loading data successful");
        message.getStyleClass().add("message");
        messageDiv.getChildren().add(message);
        messageDiv.setAlignment(Pos.CENTER);
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
    
    @FXML
    public void deleteData() {
        BlockDao bdao = new BlockDao();
        bdao.deleteData();
        Label message = new Label();
        message.setText("Deleting data successful");
        message.getStyleClass().add("message");
        messageDiv.getChildren().add(message);
        messageDiv.setAlignment(Pos.CENTER);
    }
}
