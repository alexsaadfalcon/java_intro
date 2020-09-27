import java.util.Random;
import java.util.Scanner;

/**
 * Your Pokemon Adventure begins here!
 *
 * @author Joe Rossi, Honey Chawla
 * @version 2.0
 */
public class Driver {
    private static Scanner in;
    private static Random rand;

    /**
     * Main method for Driver. Allows the user to encounter
     * Pokemon using the Walk around option, view their party,
     * report to Professor Oak, or end their Adventure (quit the
     * program).
     *
     * @param args command-line arguments for the program.
     */
    public static void main(String[] args) {
        try {
            Adventure adventure = new Adventure(args[0]);
            in = new Scanner(System.in);
            rand = new Random();

            boolean running = true;
            System.out.println("Welcome to your Adventure "
                + "in the world of Pokemon!\n");
            while (running) {
                System.out.println("What do you want to do?");
                System.out.println("1: Walk around");
                System.out.println("2: View party Pokemon");
                System.out.println("3: Report to Professor Oak");
                System.out.println("4: End adventure...");
                int choice = 0;
                try {
                    choice = Integer.parseInt(in.nextLine());
                } catch (NumberFormatException e) {
                    choice = -1;
                }
                if (choice == 1) {
                    try {
                        System.out.println("You wander around for a bit");
                        String dots = ".";
                        System.out.println(dots);
                        int ticks = 0;
                        while (rand.nextInt(100) >= 10 && ticks < 20) {
                            Thread.sleep(0);
                            dots += ".";
                            System.out.println(dots);
                            ticks++;
                        }
                        adventure.walkAround();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (choice == 2) {
                    adventure.viewParty();
                } else if (choice == 3) {
                    adventure.reportToProfessorOak();
                } else if (choice == 4) {
                    adventure.endAdventure();
                    System.out.println("Your adventure has ended!");
                    running = false;
                } else {
                    System.out.println("\nBill's PC does not "
                            + "recognize that input\n");
                }
            }
        } catch (UnknownRegionException e) {
            System.out.println(e.getMessage());
        }
    }
}