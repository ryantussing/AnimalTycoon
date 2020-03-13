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
public class Slop extends Food {
    
    public static double price;
    public static double pricePlains = 3.00;
    public static double priceRanch = 4.50;
    public static double priceWarmlands = 3.50;
    public static double priceDesert = 5.50;
    
    public Slop() {
        super(pricePlains, priceRanch, priceDesert, priceWarmlands, location, amount);
    }
    
}
