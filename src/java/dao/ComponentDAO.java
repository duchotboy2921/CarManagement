/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Component;

/**
 *
 * @author ducke
 */
public class ComponentDAO extends DAO{

    public ComponentDAO() {
        super();
    }
    public Component getComponentByID(String id){
        Component component = new Component();
        String sql = "SELECT * FROM public.tblcomponent WHERE id =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                component.setBrand(rs.getString("brand"));
                component.setId(id);
                component.setName(rs.getString("name"));
                component.setPrice(rs.getFloat("price"));
            }
        } catch (Exception e) {
        }
        return component;
    } 
    
}
