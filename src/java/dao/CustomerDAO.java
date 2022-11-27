/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Customer;

/**
 *
 * @author ducke
 */
public class CustomerDAO extends DAO{
    public CustomerDAO(){
        super();
    }
    public Customer getCustomerByID(String id){
        Customer customer = new Customer();
        String sql = "SELECT * FROM public.tblcustomer WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                customer.setId(id);
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setPhonenumber(rs.getString("phonenumber"));
                customer.setDes(rs.getString("description"));            
            }
        } catch (Exception e) {
        }
        return customer;
    }
}