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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Dominique
 */
public class BlockDao {
    private static BlockDao instance;
    
    public static BlockDao getInstance() {
        if(instance == null) {
            instance = new BlockDao();
        }
        return instance;
    }
    
    public List<Block> getAllBlocks(){
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
            
            return allBlocks;
        } catch (SQLException ex) {
            Logger.getLogger(MysqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addAllBlocks(JSONArray array) {
        Connection con = null;
        String query = "INSERT INTO block (`type`, `meta`, `name`, `text_type`) VALUES(?, ?, ?, ?)";
        
        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            
            array.forEach(block->{
                JSONObject obj = (JSONObject)block;
                try {
                    st.setInt(1, ((Long) obj.get("type")).intValue());
                    st.setInt(2, ((Long)obj.get("meta")).intValue());
                    st.setString(3, obj.get("name").toString());
                    st.setString(4, obj.get("text_type").toString());
                    st.addBatch();
                } catch (SQLException ex) {
                    Logger.getLogger(BlockDao.class.getName()).log(Level.SEVERE, null, ex);
                } 
            });
            st.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(BlockDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
