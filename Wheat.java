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
public class Wheat extends Food {
    
    public static double price;
    public static double pricePlains = 4.00;
    public static double priceRanch = 5.50;
    public static double priceWarmlands = 4.50;
    public static double priceDesert = 6.50;
    
    public Wheat () {
        super(pricePlains, priceRanch, priceDesert, priceWarmlands, location, amount);
    }
    
}
