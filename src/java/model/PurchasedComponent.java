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
public class PurchasedComponent {
    private Component component;
    private int amount;
    private float price;

    public PurchasedComponent() {
    }

    public PurchasedComponent(Component component, int amount, float price) {
        this.component = component;
        this.amount = amount;
        this.price = price;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
