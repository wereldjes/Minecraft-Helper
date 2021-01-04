package minecrafthelper.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
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
    @FXML
    private TextField searchbar;
    @FXML
    private Button searchbarButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Block b : BlockDao.getInstance().getAllBlocks()) {
            Button blockInfoButton = new Button();
            blockInfoButton.setId(String.valueOf(b.getType()));
            blockInfoButton.getStyleClass().add("blockInfoButton");
            
            blockInfoButton.setText(b.getName()+"\n"+
                    String.valueOf(b.getType()) + " - " + String.valueOf(b.getMeta()));
            
            blockList.getChildren().add(blockInfoButton);
        }
        
        menuButton.setOnAction(event->backToMenu());
        searchbarButton.setOnAction(event->searchBlock());
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
    
    public void searchBlock() {
        blockList.getChildren().clear();
        BlockDao bdao = new BlockDao();
        for(Block b : bdao.searchBlock(searchbar.getText())){
            Button blockInfoButton = new Button();
            blockInfoButton.setId(String.valueOf(b.getType()));
            blockInfoButton.getStyleClass().add("blockInfoButton");
            blockInfoButton.setText(b.getName()+"\n"+
                String.valueOf(b.getType()) + " - " + String.valueOf(b.getMeta()));
            blockList.getChildren().add(blockInfoButton);
        }

    }
}
