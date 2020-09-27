import java.util.Scanner;
import java.util.Random;

public class LemonadeTycoon {

    private enum Weather { EXTRA_SUNNY, NORMAL, CLOUDY, RAINING; }

    private static int popularity = 50;
    private static int satisfaction = 50;
    private static double salesRate = 1;
    private static double menuPriceTotal = 0.0;

    private static Scanner kybd = new Scanner(System.in);

    //Declare and initialize the menu below

    public static void main(String[] args) {
        int days = 0;

        System.out.println("Welcome to Lemonade Tycoon!");
        System.out.print("Name your Lemonade Stand: ");
        String stand = kybd.nextLine();
        System.out.println("You have named your Lemonade Stand " + stand + ".");

        boolean cont = true;
        int choice;

        while (cont) {

            System.out.println("Day " + days);
            System.out.println("What would you like to do?");
            System.out.println("1. View Menu Actions\n2. "
                + "End day\n3. Quit Game");
            choice = kybd.nextInt();
            if (choice == 1) {
                System.out.println("Menu Actions. Select one of the"
                    + " following:");
                System.out.println("1. Check Menu\n2. Add to Menu");
                System.out.println("3. Change prices");
                System.out.println("4. Cancel");
                int selection = kybd.nextInt();
                if (selection == 1) {
                    checkMenu();
                } else if (selection == 2) {
                    System.out.print("What would you like to name your item? ");
                    kybd.nextLine();
                    String name = kybd.nextLine();
                    System.out.print("How much will your item cost? ");
                    double price = kybd.nextDouble();
                    addToMenu(name, price);
                } else if (selection == 3) {
                    System.out.println("What is the name of the item you would"
                        + " like to change the price of?");
                    String itemName = kybd.nextLine();
                    changePrice(itemName);
                }
            } else if (choice == 2) {
                days++;
                //Edit the output below to include the total profits made today
                System.out.println("Day ended.");
                //Make a call to the weather forecast method below. Make sure to let
                //the player know what the weather will be like today!
            } else {
                System.out.println("Good Bye!");
                cont = false;
            }

        }
    }

      /////////////////////////////////////////////////////////////////////////
     //                 Methods for aspects of gameplay                     //
    /////////////////////////////////////////////////////////////////////////

    /**
    * Prints the entire menu out to the console.
    *
    * @return void
    **/
    private static void checkMenu() {
        //YOUR CODE HERE FOR PRINTING THE MENU OUT

    }

    /**
    * Method that adds an item and its price to the menu.
    * Uses system I/O to collect ingredient names as well.
    *
    * @param String name of the item, double price
    * @return void
    **/
    private static void addToMenu(String itemName, double price) {
        //YOUR CODE HERE FOR ADDING THE ITEM NAME AND PRICE TO THE MENU
        //Don't forget to add the item price to the menu total!

        boolean keepCollecting = true;
        System.out.println("In order to stop adding ingredients, type \"N\"");
        kybd.nextLine();
        while (keepCollecting) {
            System.out.println("What ingredient would you like to add? ");
            String in = kybd.nextLine();
            if (!(in.equals("N"))) {
                //YOUR CODE HERE FOR ADDING THE INGREDIENT TO THE MENU
            } else {
                keepCollecting = false;
            }
        }
    }

    /**
    * Method that changes the price of the item given as input.
    *
    * @param String name of the item
    * @return void
    **/
    private static void changePrice(String itemName) {
        //YOUR CODE HERE FOR ADJUSTING PRICE

    }

    /**
    * Method that randomly determines the weather
    * and prints it out for the player to see.
    * If a weather is chosen that affects popularity,
    * sales, or satisfaction, you should change it here
    * as well.
    *
    * @return void
    **/
    public static void weatherForecast() {
        //YOUR CODE HERE
        //This part is a little tricky, so start thinking about this early!

    }


    private static double getProfits() {
        return (popularity + satisfaction) * 0.1 * (salesRate * menuPriceTotal);
    }
}