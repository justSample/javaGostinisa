package justMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Just_Sample
 */
public class mySQL {
    
    public static final String DBName = "gostinitsa";
    protected static String DBURL = "jdbc:mysql://localhost:3306/" + DBName;
    protected static String DBUser = "root";
    protected static String DBPassword = "root";
    
    private static Connection getConnection(){
        
        Connection connect;
        try {
            connect = DriverManager.getConnection(DBURL, DBUser, DBPassword);
            return connect;
        } catch (SQLException ex) {
            Logger.getLogger(mySQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static Statement getStatement(){
        
        try {
            Statement stm = getConnection().createStatement();
            return stm;
        } catch (SQLException ex) {
            Logger.getLogger(mySQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public static void Insert(String Query){
        
        try {
            
            Connection con = DriverManager.getConnection(DBURL, DBUser, DBPassword);
            Statement stm = con.createStatement();
            stm.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Успешно!");
            
        } catch (SQLException ex) {
            Logger.getLogger(mySQL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ошибка!");
        }
        
    }
    
    public static ResultSet getResultAll(String tableName){
        
        try {
            ResultSet rs = getStatement().executeQuery("SELECT * FROM "+ DBName +"."+ tableName + ";");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(mySQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public static boolean HaveSQLSelect(String tableName, String uniqueIdentifier, String valueIdentifier){
    
        try {
            Statement stm = getConnection().createStatement();
            
            ResultSet rs = stm.executeQuery("SELECT * FROM "+ DBName +"."+ tableName + " WHERE (`"+uniqueIdentifier+"` = '"+valueIdentifier+"');");
            
            if(rs.next()){
                rs.close();
                stm.close();
                return true;
            }
            else{
                rs.close();
                stm.close();
                return false;
            }
            
        } catch (SQLException ex) {
            System.err.println("Error in HaveSQLSelect! ");
            Logger.getLogger(mySQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public static ResultSet getResultSQLSelect(String tableName, String uniqueIdentifier, String valueIdentifier){
    
        try {
            ResultSet rs = getStatement().executeQuery("SELECT * FROM gostinitsa."+tableName+" WHERE `"+uniqueIdentifier+"` = '"+valueIdentifier+"';");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(mySQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
    
    public static boolean HaveSQLSelect(String Query){
    
        try {
            Statement stm = getConnection().createStatement();
            
            ResultSet rs = stm.executeQuery(Query);
            
            if(rs.next()){
                rs.close();
                stm.close();
                return true;
            }
            else{
                rs.close();
                stm.close();
                return false;
            }
            
        } catch (SQLException ex) {
            System.err.println("Error in HaveSQLSelect! ");
            Logger.getLogger(mySQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
}
