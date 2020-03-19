/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import justMySQL.mySQL;
import myAbstractPackage.getterObj;

/**
 *
 * @author Just_Sample
 */
public class typeEmployment extends getterObj{
    
    private String empType;

    public typeEmployment(int id,String empType) {
        this();
        this._id = id;
        this.empType = empType;
    }
    
    public typeEmployment(){
        
        _tableName = "types_employment";
        
        if(Fields.isEmpty()){
            
            Fields.add("employment_type");
            
        }
        
    }
    

    @Override
    public List<? extends getterObj> getArrayObjects() {
    
        List<typeEmployment> typeEmpList = new ArrayList<>();
        
        try {
            ResultSet rs = mySQL.getResultAll(_tableName);
            while(rs.next()){
                
                typeEmpList.add(new typeEmployment(rs.getInt(1), rs.getString(2)));
                
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return typeEmpList;
        
    }

    public String getEmpType() {
        return empType;
    }
    
    
    
}
