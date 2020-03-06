/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animaltycoon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;
/**
 *
 * @author 802793
 */
public class AnimalTycoon {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        Scanner kb = new Scanner(System.in);
        World world = new World();
        String response = "";
        world.printMenu();
        while (!(response.equals("/close"))) {   
            response = kb.nextLine();
            world.processResponse(response);
        }
    } 
    
}
