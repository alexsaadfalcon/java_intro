import java.util.Scanner;
import java.util.Random;

public class LemonadeTycoon {

    private enum Weather { EXTRA_SUNNY, NORMAL, CLOUDY, RAINING; }

    private static int popularity = 50;
    private static int satisfaction = 50;
    private static double salesRate = 1;
    private static double menuPriceTotal = 0.0;
    private static String[][] menu = new String[10][10];
    private static int numItems = 0; //current index of item to put in

    private static Weather currentWeather;

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
                    //String itemName = kybd.nextLine();
                    //^^for some reason this line was skipped at run-time
                    //I used a different Scanner instead, and it works
                    Scanner kybd2 = new Scanner(System.in);
                    String itemName = kybd2.nextLine();
                    changePrice(itemName);
                }
            } else if (choice == 2) {
                days++;
                //Edit the output below to include the total profits made today
                double profit = getProfits();
                System.out.printf("Day ended. Profits were $%.2f\n", profit);
                //Make a call to the weather forecast method below.
                //Let the player know what the weather will be like today!
                weatherForecast();
                System.out.println("The Weather is going to be "
                    + currentWeather.name());
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
        for (int i = 0; i < menu.length; i++) {
            if (menu[i][0] != null) {
                System.out.printf(menu[i][0]
                    + " -- $%.2f -- ", Double.parseDouble(menu[i][1]));
                if (menu[i][2] != null) {
                    System.out.print(menu[i][2]);
                } else {
                    System.out.print("No Ingredients");
                }
                for (int j = 3; j < menu[i].length; j++) {
                    if (menu[i][j] != null) {
                        System.out.print(", " + menu[i][j]);
                    }
                }
                System.out.println();
            }
        }
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
        boolean itemExists = false;
        for (int i = 0; i < menu.length; i++) {
            if (itemName.equalsIgnoreCase(menu[i][0])) {
                System.out.println("That item already exists");
                itemExists = true;
            }
        }
        if (!itemExists) {
            if (numItems < menu.length) { //If array hasn't been maxed
                menu[numItems][0] = itemName;
                menu[numItems][1] = "" + price;
                menuPriceTotal += price;
            } else { //If array has reached max capacity
                String[][] newMenu = new String[menu.length * 2][10];
                for (int i = 0; i < menu.length; i++) {
                    for (int j = 0; j < menu[i].length; j++) {
                        newMenu[i][j] = menu[i][j];
                    }
                }
                menu = newMenu;
                menu[numItems][0] = itemName;
                menu[numItems][1] = "" + price;
                menuPriceTotal += price;
            }

            boolean keepCollecting = true;
            System.out.println("In order to stop adding ingredients,"
                + " type \"N\"");
            kybd.nextLine();
            int currentIngredient = 2;
            while (keepCollecting) {
                System.out.println("What ingredient would you like to add? ");
                String in = kybd.nextLine();
                if (!(in.equals("N"))) {
                    menu[numItems][currentIngredient] = in;
                    currentIngredient++;
                } else {
                    keepCollecting = false;
                }
            }
            numItems++;
        }
    }

    /**
    * Method that changes the price of the item given as input.
    *
    * @param String name of the item
    * @return void
    **/
    private static void changePrice(String itemName) {
        boolean itemExists = false;
        for (int i = 0; i < menu.length; i++) {
            if (menu[i][0] != null && menu[i][0].equalsIgnoreCase(itemName)) {
                double oldPrice = Double.parseDouble(menu[i][1]);
                System.out.print("What would you like the new price to be? ");
                double price = kybd.nextDouble();
                menuPriceTotal = menuPriceTotal - oldPrice + price;
                menu[i][1] = "" + price;
                itemExists = true;
            }
        }
        if (!itemExists) {
            System.out.println("I'm sorry, "
                + "but that item doesn't exist in the menu.");
        }
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
        Random rand = new Random();
        int newWeatherIndex = rand.nextInt(4);
        currentWeather = Weather.values()[newWeatherIndex];
        switch (currentWeather) {
        case EXTRA_SUNNY:
            popularity += rand.nextInt(11); //from 0 to 10, inclusive
            break;
        case NORMAL:
            salesRate = 1;
            popularity = 50;
            satisfaction = 50;
            break;
        case CLOUDY:
            satisfaction -= rand.nextInt(satisfaction);
            //random decrease range is up to satisfaction
            break;
        case RAINING:
            salesRate -= salesRate * rand.nextDouble();
            //random decrease range is up to salesRate
            break;
        default:
            break;
        }
    }


    private static double getProfits() {
        return (popularity + satisfaction) * 0.1 * (salesRate * menuPriceTotal);
    }
}