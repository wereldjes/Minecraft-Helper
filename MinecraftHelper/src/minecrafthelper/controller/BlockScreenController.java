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
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import static javafx.scene.paint.Color.color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Block b : BlockDao.getInstance().getAllBlocks()) {
            VBox blockInfo = new VBox();
            Label blockName = new Label();
            
            blockInfo.setAlignment(Pos.CENTER);
            blockInfo.getStyleClass().add("blockInfo");
            blockName.setText(b.getName());
            
            blockInfo.getChildren().add(blockName);
            
            blockList.getChildren().add(blockInfo);
        }
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
}
