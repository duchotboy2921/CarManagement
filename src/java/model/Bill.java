/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ducke
 */
public class Bill {
    private String id,date,paymentType,note;
    private boolean isPaid;
    private User cashier;
    private Customer customer;
    private MaintainCar maintainCar;

    public Bill() {
    }

    public Bill(String id, String date, String paymentType, String note, boolean isPaid, User cashier, Customer customer, MaintainCar maintainCar) {
        this.id = id;
        this.date = date;
        this.paymentType = paymentType;
        this.note = note;
        this.isPaid = isPaid;
        this.cashier = cashier;
        this.customer = customer;
        this.maintainCar = maintainCar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public User getCashier() {
        return cashier;
    }

    public void setCashier(User cashier) {
        this.cashier = cashier;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public MaintainCar getMaintainCar() {
        return maintainCar;
    }

    public void setMaintainCar(MaintainCar maintainCar) {
        this.maintainCar = maintainCar;
    }
    
}
