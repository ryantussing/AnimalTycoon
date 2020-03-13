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
-- create a structure for progressing through days                              (x)
-- link locations to prices - location from food to classes                     (x)
-- upgrade() method -> if sufficient money -> double check / if not -> reply    ()
-- figure out how to gather the user's name                                     ()
-- use the same method to get a location for the farm                           ()
-- give the location attributes and create animal classes                       ()
-- create a method to run the actual game                                       ()

** create an entirely new class called processor (refactor "world"), then create
   a class named world with the parameters chosen by the user
*/

public class World {
    
    private String location;
    private int week = 1;
    private double money = 100.00;
    
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
    private boolean runDay;
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
                    + "\n\n\t/rules - use at any time to print rules\n\t/close - use to close game at any time"
                    + "\n\t/money - use to print money at any time\n\n~~~~~~~~~");
        }
        if ((response.equals("exit") || response.equals("Exit") || response.equals("exit game") || response.equals("Exit Game")) && menu) {
            System.exit(0);
        }
        if (response.equals("/close")) {
            System.exit(0);
        }
        if (response.equals("/money")) {
            System.out.println("~~~~~~~\nMONEY : $ " + String.format("%.2f", money) + "\n~~~~~~~");
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
                intro4 = false; response = " "; location = "plains"; Food.location = location; endIntro = true;
                printIntro(); runWeek(location); runDay = true;
            }
            if (response.equals("desert") || response.equals("Desert")){
                intro4 = false; response = " "; location = "desert"; Food.location = location; endIntro = true;
                printIntro(); runWeek(location); runDay = true;
            }
            if (response.equals("ranch") || response.equals("Ranch")){
                intro4 = false; response = " "; location = "ranch"; Food.location = location; endIntro = true;
                printIntro(); runWeek(location); runDay = true;
            }
            if (response.equals("warmlands") || response.equals("Warmlands")){
                intro4 = false; response = " "; location = "warmlands"; Food.location = location; endIntro = true;
                printIntro(); runWeek(location); runDay = true;
            }
        }
        if (runDay) {
            if (response.equals("end week") || response.equals("End Week")) {
                week++; runWeek(location);
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
    
    public void runWeek(String location) {
        if (week <= 52) {
            if (location.equals("ranch")) {
                
                System.out.println("|-------------------------||-------------------------|\n\tWEEK: " + week + "\n\tMONEY: $ " + 
                        String.format("%.2f", money) + "\n\nMARKET PRICES: \n\n\tCOW:     $ " + String.format("%.2f", Cow.price) + 
                        "\t  WHEAT: $" + String.format("%.2f", Wheat.priceRanch) + "\n\tPIG:     $ " + String.format("%.2f", Pig.price) + 
                        "\t  SLOP:  $" + String.format("%.2f", Slop.priceRanch) + "\n\tCHICKEN: $ " + 
                        String.format("%.2f", Chicken.price) + "\t\t  SEED:  $" + String.format("%.2f", Seed.priceRanch) +
                        "\n\nYOUR INVENTORY:\n\t\t\t\t(weekly servings)\n\tCOWS:    " + Cow.amount + "\t\t  WHEAT: " + Wheat.amount +
                        "\n\tPIGS:    " + Pig.amount + "\t\t  SLOP:  " + Slop.amount + 
                        "\n\tCHICKEN: " + Chicken.amount + "\t\t  SEED:  " + Seed.amount + 
                        "\n|-------------------------||-------------------------|");
                System.out.println("~~~~~~~\n\tWhat would you like to do?\n\t\t-  Buy Food\n\t\t-  Buy Animals"
                        + "\n\t\t-  Check Hunger\n\t\t-  Upsize Farm\n~~~~~~~");
            }
            if (location.equals("warmlands")) {
                System.out.println("|-------------------------||-------------------------|\n\tWEEK: " + week + "\n\tMONEY: $ " + 
                        String.format("%.2f", money) + "\n\nMARKET PRICES: \n\n\tCOW:     $ " + String.format("%.2f", Cow.price) + 
                        "\t  WHEAT: $" + String.format("%.2f", Wheat.priceWarmlands) + "\n\tPIG:     $ " + String.format("%.2f", Pig.price) + 
                        "\t  SLOP:  $" + String.format("%.2f", Slop.priceWarmlands) + "\n\tCHICKEN: $ " + 
                        String.format("%.2f", Chicken.price) + "\t\t  SEED:  $" + String.format("%.2f", Seed.priceWarmlands) +
                        "\n\nYOUR INVENTORY:\n\t\t\t\t(weekly servings)\n\tCOWS:    " + Cow.amount + "\t\t  WHEAT: " + Wheat.amount +
                        "\n\tPIGS:    " + Pig.amount + "\t\t  SLOP:  " + Slop.amount + 
                        "\n\tCHICKEN: " + Chicken.amount + "\t\t  SEED:  " + Seed.amount +
                        "\n|-------------------------||-------------------------|");
                System.out.println("~~~~~~~\n\tWhat would you like to do?\n\t\t-  Buy Food\n\t\t-  Buy Animals"
                        + "\n\t\t-  Check Hunger\n\t\t-  Upsize Farm\n~~~~~~~");
            }
            if (location.equals("desert")) {
                System.out.println("|-------------------------||-------------------------|\n\tWEEK: " + week + "\n\tMONEY: $ " + 
                        String.format("%.2f", money) + "\n\nMARKET PRICES: \n\n\tCOW:     $ " + String.format("%.2f", Cow.price) + 
                        "\t  WHEAT: $" + String.format("%.2f", Wheat.priceDesert) + "\n\tPIG:     $ " + String.format("%.2f", Pig.price) + 
                        "\t  SLOP:  $" + String.format("%.2f", Slop.priceDesert) + "\n\tCHICKEN: $ " + 
                        String.format("%.2f", Chicken.price) + "\t\t  SEED:  $" + String.format("%.2f", Seed.priceDesert) +
                        "\n\nYOUR INVENTORY:\n\t\t\t\t(weekly servings)\n\tCOWS:    " + Cow.amount + "\t\t  WHEAT: " + Wheat.amount +
                        "\n\tPIGS:    " + Pig.amount + "\t\t  SLOP:  " + Slop.amount + 
                        "\n\tCHICKEN: " + Chicken.amount + "\t\t  SEED:  " + Seed.amount +
                        "\n|-------------------------||-------------------------|");
                System.out.println("~~~~~~~\n\tWhat would you like to do?\n\t\t-  Buy Food\n\t\t-  Buy Animals"
                        + "\n\t\t-  Check Hunger\n\t\t-  Upsize Farm\n~~~~~~~");
            }
            if (location.equals("plains")) {
                System.out.println("|-------------------------||-------------------------|\n\tWEEK: " + week + "\n\tMONEY: $ " + 
                        String.format("%.2f", money) + "\n\nMARKET PRICES: \n\n\tCOW:     $ " + String.format("%.2f", Cow.price) + 
                        "\t  WHEAT: $" + String.format("%.2f", Wheat.pricePlains) + "\n\tPIG:     $ " + String.format("%.2f", Pig.price) + 
                        "\t  SLOP:  $" + String.format("%.2f", Slop.pricePlains) + "\n\tCHICKEN: $ " + 
                        String.format("%.2f", Chicken.price) + "\t\t  SEED:  $" + String.format("%.2f", Seed.pricePlains) +
                        "\n\nYOUR INVENTORY:\n\t\t\t\t(weekly servings)\n\tCOWS:    " + Cow.amount + "\t\t  WHEAT: " + Wheat.amount +
                        "\n\tPIGS:    " + Pig.amount + "\t\t  SLOP:  " + Slop.amount + 
                        "\n\tCHICKEN: " + Chicken.amount + "\t\t  SEED:  " + Seed.amount +
                        "\n|-------------------------||-------------------------|");
                System.out.println("~~~~~~~\n\tWhat would you like to do?\n\t\t-  Buy Food\n\t\t-  Buy Animals"
                        + "\n\t\t-  Check Hunger\n\t\t-  Upsize Farm\n~~~~~~~");
            }
        }
    }
    
}