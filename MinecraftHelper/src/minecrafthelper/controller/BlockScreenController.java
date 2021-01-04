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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import minecrafthelper.Domain.Block;
import minecrafthelper.datalayer.BlockDao;

/**
 * FXML Controller class
 *
 * @author Dominique
 */
public class BlockScreenController implements Initializable {
    
    @FXML
    private FlowPane blockList;
    @FXML
    private Button menuButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Block b : BlockDao.getInstance().getAllBlocks()) {
            VBox blockInfo = new VBox();
            blockInfo.getStyleClass().add("blockBoxInfo");
            blockInfo.setFillWidth(true);
            Label blockName = new Label();
            blockName.setMaxWidth(Double.MAX_VALUE);
            Label blockId = new Label();
            
            blockInfo.setAlignment(Pos.CENTER);
            blockInfo.getStyleClass().add("blockInfo");
            blockName.setText(b.getName());
            blockId.setText(String.valueOf(b.getType()) + " - " + String.valueOf(b.getMeta()));
            
            blockInfo.getChildren().add(blockName);
            blockInfo.getChildren().add(blockId);
            
            blockList.getChildren().add(blockInfo);
        }
        
        menuButton.setOnAction(event->backToMenu());
    }    
    
    public BlockScreenController(Stage stage){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/minecrafthelper/resources/BlockScreen.fxml"));
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
    
    public void backToMenu() {
        Stage stage = (Stage) menuButton.getScene().getWindow();
        HomeController hc = new HomeController(stage);
    
    }
}
