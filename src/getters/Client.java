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
public class Client extends getterObj{
    
    private String name;
    private String phone;
    private int roomNumber;

    public Client(int id, String name, String phone, int roomNumber) {
        this();
        this._id = id;
        this.name = name;
        this.phone = phone;
        this.roomNumber = roomNumber;
    }
    
    public Client(){
        
        _tableName = "clients";
        
        if(Fields.isEmpty()){
            Fields.add("client_name");
            Fields.add("client_phone");
            Fields.add("room_number");
        }
        
    }

    @Override
    public List<? extends getterObj> getArrayObjects() {
    
        List<Client> clients = new ArrayList<>();
        
        try {
            ResultSet rs = mySQL.getResultAll(_tableName);
            while(rs.next()){
                
                clients.add(new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
                
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clients;
        
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    
}
