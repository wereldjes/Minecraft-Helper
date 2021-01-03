package minecrafthelper.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dominique
 */
public class BlockScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
