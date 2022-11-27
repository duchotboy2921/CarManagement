/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Car;

/**
 *
 * @author ducke
 */
public class CarDAO extends DAO{
    public CarDAO(){
        super();
    }
    public Car getCarByID(String id){
       Car car = new Car();
       String sql = "SELECT * FROM public.tblcar WHERE id =?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                car.setId(id);
                car.setBrand(rs.getString("brand"));
                car.setType(rs.getString("type"));
                car.setNumber(rs.getString("number"));
                car.setDes(rs.getString("description"));
                System.out.println(rs.getString("type"));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return car;
    }
    
}
