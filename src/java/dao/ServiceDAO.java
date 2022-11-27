/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Service;

/**
 *
 * @author ducke
 */
public class ServiceDAO extends DAO{

    public ServiceDAO() {
        super();
    }
    public Service getServiceByID(String id){
        Service service = new Service();
        String sql = "SELECT * FROM public.tblservice WHERE id =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                service.setId(id);
                service.setName(rs.getString("name"));
                service.setPrice(rs.getFloat("price"));
                service.setNote(rs.getString("note"));            
            }
        } catch (Exception e) {
        }
        return service;
    }
    
}
