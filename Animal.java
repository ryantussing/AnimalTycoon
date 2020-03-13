/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animaltycoon;

/**
 *
 * @author 802793
 */
public class Animal {
    
    private double price;
    private String location;
    public static int amount;
    
    public Animal (double price, int amount) {
        this.price = price;
        this.amount = amount;
    }

//    public String getLocation() {
//        return location;
//    }
//    public void setLocation(String location) {
//        this.location = location;
//    }
    
}
