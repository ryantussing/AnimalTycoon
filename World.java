/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animaltycoon;

import java.util.Scanner;
/**
 *
 * @author 802793
 */

/*
-- finish the implementation of "intro4"/individual locations                   (x)
-- create a structure for progressing through days                              (/)
-- link locations to prices                                                     ()
-- figure out how to gather the user's name                                     ()
-- use the same method to get a location for the farm                           ()
-- give the location attributes and create animal classes                       ()
-- create a method to run the actual game                                       ()

** create an entirely new class called processor (refactor "world"), then create
   a class named world with the parameters chosen by the user
*/

public class World {
    
    private String name, location;
    private int week = 1;
    private double money = 100;
    
    private boolean intro1;
    private boolean intro2;
    private boolean intro3;
    private boolean intro4;
    private boolean introPlains;
    private boolean introRanch;
    private boolean introDesert;
    private boolean introWarmlands;
    private boolean locationChoice;
    private boolean endIntro;
    private boolean runGame;
    private boolean endDay;
    private boolean menu;
    
    private int introLocation = 0;
    
    Scanner kb = new Scanner(System.in);
    
     public World() {
         
    }
    
    public void processResponse(String response) {
        if (response.equals("skip")) {
            locationChoice = true;
        }
        if ((response.equals("play") || response.equals("Play") || response.equals("play game") || response.equals("Play Game")) && menu) {
            menu = false; intro1 = true; printIntro();
        }
        if (response.equals("rules") || response.equals("Rules") || response.equals("/rules")) {
            System.out.println("~~~~~~~~~~~~~~~~~\n      RULES\n~~~~~~~~~~~~~~~~~"
                    + "\n\n~You have 52 weeks to run your farm and make the most money possible! Choose a location based on"
                    + "\nthe benefits it provides, then purchase your animals and raise them to the highest value!~"
                    + "\n\n\t/rules - use at any time to print rules\n\t/close - use to close game at any time\n\n~~~~~~~~~");
        }
        if ((response.equals("exit") || response.equals("Exit") || response.equals("exit game") || response.equals("Exit Game")) && menu) {
            System.exit(0);
        }
        if (response.equals("/close")) {
            System.exit(0);
        }
        if (intro1) {
            if (response.equals("")){
                intro1 = false; intro2 = true; response = " ";
                printIntro();
            }
        }
        if (intro2) {
            if (response.equals("")){
                intro2 = false; intro3 = true; response = " ";
                printIntro(); 
            }
        }
        if (intro3) {
            if (response.equals("warmlands") || response.equals("Warmlands")){
                introWarmlands = true; response = " "; intro3 = false;
                introLocation++; printIntro(); intro3 = true; introWarmlands = false;
            }
            if (response.equals("desert") || response.equals("Desert")){
                introDesert = true; response = " "; intro3 = false;
                introLocation++; printIntro(); intro3 = true; introDesert = false;
            }
            if (response.equals("Ranch") || response.equals("ranch")){
                introRanch = true; response = " "; intro3 = false;
                introLocation++; printIntro(); intro3 = true; introRanch = false;
            }
            if (response.equals("plains") || response.equals("Plains")){
                introPlains = true; response = " "; intro3 = false;
                introLocation++; printIntro();  intro3 = true; introPlains = false;
            }
            if (response.equals("no") || response.equals("No")){
                intro3 = false; intro4 = true; response = " "; printIntro();
            }
        }
        if (locationChoice) {
            if (response.equals("plains") || response.equals("Plains")){
                intro4 = false; response = " "; location = "plains"; endIntro = true;
                printIntro(); runGame(location); runGame = true;
            }
            if (response.equals("desert") || response.equals("Desert")){
                intro4 = false; response = " "; location = "desert"; endIntro = true;
                printIntro(); runGame(location); runGame = true;
            }
            if (response.equals("ranch") || response.equals("Ranch")){
                intro4 = false; response = " "; location = "ranch"; endIntro = true;
                printIntro(); runGame(location); runGame = true;
            }
            if (response.equals("warmlands") || response.equals("Warmlands")){
                intro4 = false; response = " "; location = "warmlands"; endIntro = true;
                printIntro(); runGame(location); runGame = true;
            }
        }
        if (runGame) {
            if (response.equals("end day") || response.equals("End Day")) {
                endDay = true;
            }
        }
    }
    
    public void printMenu () {
        menu = true;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\tANIMAL TYCOON\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("   1)\tPlay Game\n   2)\tRules\n   3)\tExit Game\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
    }
    
    public void printIntro() {
        if (intro1) {
            System.out.println("~~~~~~~~~~\nChief:\tHowdy partner! My name is Chief, and I'll be \n\t"
                    + "here to help you get started on your new farm!"/*\n\n\tWhat's your name?\n~~~~~~~*/);
        }
        if (intro2) {
            System.out.println(/*~~~~~~~\n*/"\tFirst thing's first, you need to "
                    + "\n\tdecide where you want your farm!");
        }
        if (intro3) {
            System.out.println("\tThere are several different places you can locate your farm:"
                    + "\n\t   1)Plains"
                    + "\n\t   2)Ranch"
                    + "\n\t   3)Desert"
                    + "\n\t   4)Warmlands"
                    + "\n\n\tWould you like to learn about any of the locations?\n~~~~~~~");
        }
        if (introPlains) {
            System.out.println("~~~~~~~\n\tIn the plains, the cost for food and water is relatively inexpensive. However, "
                    + "there is a \n\tlarge supply of meat in the plains. You need to make sure your meat is high quality."
                    + " \n\tProperty prices are average in the plains, so be aware if you plan to upsize.");
        }
        if (introRanch) {
            System.out.println("~~~~~~~\n\tFood and water on the ranch are both averagely priced. However, the value of the meat "
                    + "\n\tfrom the ranch is higher than that of the Plains and Warmlands. There's a lot of\n\t"
                    + "land available in the plains, so expanding won't set you back too much.");
        }
        if (introDesert) {
            System.out.println("~~~~~~~\n\tBecause it's so difficult to source food and water, prices of supplies "
                    + "in the Desert are much\n\thigher than normal. But this doesn't come without a reward; "
                    + "the value of the meat from \n\tthe Desert is the highest anywhere! In addition, there's "
                    + "almost no competition for land!");
        }
        if (introWarmlands) {
            System.out.println("~~~~~~~\n\tJust like the plains, food and water is relatively light on costs in the \n\t"
                    + "Warmlands. Meat sells at an average price in the Warmlands, but there isn't a \n\t"
                    + "whole lot of open land in this region. Property is the most expensive here.");
        }
        if ((introWarmlands || introDesert || introRanch || introPlains)) {
            if (introLocation < 4) {
                System.out.println("\n\tWould you like to learn about another location?\n~~~~~~~");
            }
            if (introLocation == 4) {
                System.out.println("\n\tThat's all of 'em, now it's time too choose a location! What's your choice?\n~~~~~~~");
                intro3 = false; locationChoice = true;
            }
        }
        if (intro4) {
            System.out.println("~~~~~~~\n\tAlrighty partner, where would you like your farm?\n~~~~~~~");
            locationChoice = true;
        }
        if (endIntro) {
            System.out.println("~~~~~~~~~~\nChief:\tThat's a great choice! Your brand new farm is located on the " + location + "!"
                    + "\n\tYou have $100 to start with, good luck!\n~~~~~~~\n");
        }
    }
    
    public void runGame(String location) {
//        do {
        for (int i = week; i <= 60; i++) {
            System.out.println("|-------------------------||-------------------------|\n\tDAY: " + week + "\n\tMONEY: $ " + 
                    String.format("%.2f", money) + "\n\nMARKET PRICES: \n\n\tCOW:     $ " + String.format("%.2f", Cow.price) + 
                    "\t  WHEAT: $" + String.format("%.2f", Wheat.price) + "\n\tPIG:     $ " + String.format("%.2f", Pig.price) + 
                    "\t  SLOP:  $" + String.format("%.2f", Slop.price) + "\n\tCHICKEN: $ " + 
                    String.format("%.2f", Chicken.price) + "\t\t  SEED:  $" + String.format("%.2f", Seed.price) +
                    "\n|-------------------------||-------------------------|");
            week++;
        }
//        } while(!endDay);
    }
    
}
