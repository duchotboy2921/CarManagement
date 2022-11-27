/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Bill;
import model.User;

/**
 *
 * @author ducke
 */
public class Test {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        CarDAO carDAO = new CarDAO();
        SlotDAO slotDAO = new SlotDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        ServiceDAO serviceDAO = new ServiceDAO();
        BillDAO billDAO = new BillDAO();
        //System.out.println(userDAO.checkLogin(new User(1,"minhduc","minhduc","nguyen","000","","","")));;
//        System.out.println(carDAO.getCarByID("112").toString());
//        System.out.println(slotDAO.getSlotByID("111"));
//        System.out.println(customerDAO.getCustomerByID("111").toString());
//        System.out.println(serviceDAO.getServiceByID("111"));
        Bill bill = billDAO.searchBillByID("111");
        System.out.println(bill.getMaintainCar().getListPurchasedComponents().size());
    }
}
