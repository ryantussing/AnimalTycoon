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
public class Seed extends Food {
   
   public static double pricePlains = 2.00;
   public static double priceRanch = 3.50;
   public static double priceWarmlands = 2.50;
   public static double priceDesert = 4.50;
    
    public Seed () {
        super(pricePlains, priceRanch, priceDesert, priceWarmlands, location, amount);
        
    }
    
}
