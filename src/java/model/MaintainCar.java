/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author ducke
 */
public class MaintainCar {
    private String id,note;
    private float total;
    private Slot slot;
    private Car car;
    private List<PurchasedComponent> listPurchasedComponents;
    private List<PurchasedService> listPurchasedServices;
    private User technician;
    private Customer customer;

    public MaintainCar() {
    }

    public MaintainCar(String id, String note, float total, Slot slot, Car car, List<PurchasedComponent> listPurchasedComponents, List<PurchasedService> listPurchasedServices, User technician, Customer customer) {
        this.id = id;
        this.note = note;
        this.total = total;
        this.slot = slot;
        this.car = car;
        this.listPurchasedComponents = listPurchasedComponents;
        this.listPurchasedServices = listPurchasedServices;
        this.technician = technician;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<PurchasedComponent> getListPurchasedComponents() {
        return listPurchasedComponents;
    }

    public void setListPurchasedComponents(List<PurchasedComponent> listPurchasedComponents) {
        this.listPurchasedComponents = listPurchasedComponents;
    }

    public List<PurchasedService> getListPurchasedServices() {
        return listPurchasedServices;
    }

    public void setListPurchasedServices(List<PurchasedService> listPurchasedServices) {
        this.listPurchasedServices = listPurchasedServices;
    }

    public User getTechnician() {
        return technician;
    }

    public void setTechnician(User technician) {
        this.technician = technician;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
