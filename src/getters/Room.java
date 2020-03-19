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
public class Room extends getterObj{

    private int roomNumber;
    private String roomType;
    private String roomEmp;

    public Room(int roomNumber, String roomType, String roomEmp) {
        this();
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomEmp = roomEmp;
    }
    
    public Room(){
        
        _tableName = "rooms";
        
        if(Fields.isEmpty()){
            Fields.add("room_number");
            Fields.add("room_type");
            Fields.add("room_employment");
        }
        
    }
    
    @Override
    public List<? extends getterObj> getArrayObjects() {
    
            List<Room> rooms = new ArrayList<>();
        
        try {
            ResultSet rs = mySQL.getResultAll(_tableName);
            while(rs.next()){
                
                rooms.add(new Room(rs.getInt(2), rs.getString(3), rs.getString(4)));
                
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rooms;
        
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomEmp() {
        return roomEmp;
    }
    
    
}
