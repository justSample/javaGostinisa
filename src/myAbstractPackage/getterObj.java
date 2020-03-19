package myAbstractPackage;

import getters.Admin;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import justMySQL.mySQL;

/**
 * @author Just_Sample
 */
public abstract class getterObj {
    
    public int _id;
    protected final String DBNAME = justMySQL.mySQL.DBName;
    public String _tableName;
    public List<String> Fields = new ArrayList<>();
    
    public abstract List<? extends getterObj> getArrayObjects();
    
    public void executeSQLInsert(String tableName,List<String> fielnds, List<String> values){
        
        String query;
        int valuesCount = fielnds.size();
        
        query = "INSERT INTO ";
        query += "`"+DBNAME+"`.`"+tableName+"` ";
        
        //Fields set
        for(int i = 0;i < fielnds.size() ;i++){
        
            if(i == 0){
                query += "(`" + fielnds.get(i) + "`, ";
            }else if(i == fielnds.size() - 1){
                query += "`" + fielnds.get(i) + "`) ";
            }else{
                query += "`" + fielnds.get(i) + "`, ";
            }
        }
        
        query += "VALUES ";
        
        //Values set
        for(int i = 0;i < valuesCount ;i++){
        
            if(i == 0){
                query += "('" + values.get(i) + "', ";
            }else if(i == valuesCount - 1){
                query += "'" + values.get(i) + "')";
            }else{
                query += "'" + values.get(i) + "', ";
            }
        }
        
        query += ";";
        System.out.println(query);
        
        int result;
        try {
            result = mySQL.getStatement().executeUpdate(query);
            
            if(result == 1)
                JOptionPane.showMessageDialog(null, "Insert complete!");
                
            mySQL.getStatement().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Insert failed!");
            Logger.getLogger(getterObj.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void executeSQLUpdate(String tableName,List<String> fieldSet, List<String> values, String uniqueIdentifier, String valueIdentifier){
        
        String query;
        int valuesCount = fieldSet.size();
        
        query = "UPDATE ";
        query += "`"+DBNAME+"`.`"+tableName+"` ";
        query += "SET ";
        
        for (int i = 0; i < valuesCount; i++) {
                
            if(i == valuesCount - 1){
                
                query += "`"+ fieldSet.get(i) +"` ";
                query += "= ";
                query += "'"+ values.get(i) +"' ";
                
            }else{
                
                query += "`"+ fieldSet.get(i) +"` ";
                query += "= ";
                query += "'"+ values.get(i) +"', ";
                
            }
        }
        
        query += "WHERE ";
        query += "(`"+uniqueIdentifier+"` = '"+valueIdentifier+"')";
        
        query += ";";
        System.out.println(query);
        
        int result;
        try {
            result = mySQL.getStatement().executeUpdate(query);
            
            if(result == 1)
                JOptionPane.showMessageDialog(null, "Update complete!");
                
            mySQL.getStatement().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update failed!");
            Logger.getLogger(getterObj.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void executeSQLDelete(String tableName,String uniqueIdentifier, String valueIdentifier){
    
        String query;
        
        query = "DELETE FROM ";
        query += "`"+DBNAME+"`.`"+tableName+"` ";
        
        query += "WHERE ";
        query += "(`"+uniqueIdentifier+"` = '"+valueIdentifier+"')";
        
        query += ";";
        System.out.println(query);
        
        int result;
        try {
            result = mySQL.getStatement().executeUpdate(query);
            
            if(result == 1)
                JOptionPane.showMessageDialog(null, "Delete complete!");
                
            mySQL.getStatement().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Delete failed!");
            Logger.getLogger(getterObj.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void executeSQL(String Query){
        
        try {
                int result = mySQL.getStatement().executeUpdate(Query);
                
                if(result == 1)
                    JOptionPane.showMessageDialog(null,"Запрос успешно выполнился!");
                
                mySQL.getStatement().close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Запрос успешно провалился!");
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
    }
    
    public void ShowInfo(){
        
        System.out.println("Size array: " + getArrayObjects().size());
        
    }
    
    public int getId(){
        return _id;
    }
     
}