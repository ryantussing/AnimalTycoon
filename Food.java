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
public class Food {
    
    public static double pricePlains;
    public static double priceRanch;
    public static double priceDesert;
    public static double priceWarmlands;
    public static String location;
    public static int amount;
    
    public Food (double pricePlains, double priceRanch, double priceDesert, double priceWarmlands, String location, int amount) {
        this.priceRanch = priceRanch;
        this.priceDesert = priceDesert;
        this.priceWarmlands = priceWarmlands;
        this.pricePlains = pricePlains;
        this.location = location;
        this.amount = amount;
        
    }
    
}
