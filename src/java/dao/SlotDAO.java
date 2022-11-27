/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Slot;

/**
 *
 * @author ducke
 */
public class SlotDAO extends DAO{
    public SlotDAO(){
        super();
    }
    
    public Slot getSlotByID(String slotID){
        Slot sl = new Slot();
        String sql = "SELECT * FROM public.tblslot WHERE id =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, slotID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sl.setId(slotID);
                sl.setNumber(rs.getInt("number"));
                sl.setPosition(rs.getString("position"));
                System.out.println(rs.getInt("number"));
            }
        } catch (Exception e) {
        }
        return sl;
    }
}
