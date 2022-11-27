/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Bill;

/**
 *
 * @author ducke
 */
public class BillDAO extends DAO{
    private UserDAO userDAO;
    private CustomerDAO customerDAO;
    private MaintainCarDAO maintainCarDAO;
    public BillDAO() {
        super();
        userDAO = new UserDAO();
        customerDAO = new CustomerDAO();
        maintainCarDAO = new MaintainCarDAO();
    }
    public Bill searchBillByID(String billID){
        Bill bill = new Bill();
        String sql = "SELECT * "
                + "FROM public.tblbill "
                + "WHERE id = ?";
        try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, billID);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 bill.setIsPaid(rs.getBoolean("ispaid"));
                 bill.setNote(rs.getString("note"));
                 bill.setDate(rs.getString("date"));
                 bill.setPaymentType(rs.getString("paymenttype"));
                 bill.setId(billID);
                 bill.setCashier(userDAO.getUserByID(rs.getString("userid")));
                 bill.setCustomer(customerDAO.getCustomerByID(rs.getString("customerid")));
                 bill.setMaintainCar(maintainCarDAO.getMainTainCarByID(rs.getString("maintaincarid")));
             }
               
        } catch (Exception e) {
            System.out.println(e);
        }
        return bill;
    } 
    public boolean changePaidStatus(String idBill, boolean ispaid){
        boolean isSucess = false;
        String sql = "UPDATE public.tblbill SET ispaid = ? WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, ispaid);
            ps.setString(2, idBill);
            isSucess = ps.execute();
        } catch (Exception e) {
        }
        return isSucess;
    }
   
}
