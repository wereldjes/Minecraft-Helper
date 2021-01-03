package minecrafthelper.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import minecrafthelper.Domain.Block;

/**
 *
 * @author Dominique
 */
public class BlockDao {
    
    public void getAllBlocks(){
        Connection con = null;
        List<Block> allBlocks = new ArrayList<>();
        String query = "SELECT * FROM block";
        
        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Block b = new Block(rs.getInt("type"), rs.getInt("meta"), rs.getString("name"), rs.getString("text_type"));
                allBlocks.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
