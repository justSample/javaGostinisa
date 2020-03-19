
package getters;

import myAbstractPackage.getterObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import justMySQL.*;

/**
 *
 * @author Just_Sample
 */
public class Admin extends getterObj{

    private String _login;
    private String _password;

    public Admin(String login, String password) {
        
        this();
        this._login = login;
        this._password = password; 
        
    }
    
    public Admin(){
        
        _tableName = "admins";
        
        if(Fields.isEmpty()){
            Fields.add("login");
            Fields.add("password");
        }
    }
    
    @Override
    public List<? extends getterObj> getArrayObjects() {
        
        List<Admin> admins = new ArrayList<>();
        
        try {
            ResultSet rs = mySQL.getResultAll(_tableName);
            while(rs.next()){
                
                admins.add(new Admin(rs.getString(2), rs.getString(3)));
                
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return admins;
        
    }
    
    @Override
    public void ShowInfo(){
        
        List<Admin> check = (List<Admin>)getArrayObjects();
        
        System.out.println("Size array: " + getArrayObjects().size());
        for(int i = 0;i < getArrayObjects().size();i++){
            System.out.println("Login: " + check.get(i).getLogin() + "  Password: " + check.get(i).getPassword());
        }
    }

    public String getLogin() {
        return _login;
    }

    public String getPassword() {
        return _password;
    }
        
}