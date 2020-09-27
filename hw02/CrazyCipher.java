import java.util.Scanner;

public class CrazyCipher {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Scanner kb2 = new Scanner(System.in);
        boolean runCond = true; //condition for code to keep running
        System.out.println("Welcome to the CS1331 Crrrrrrazy Cipher :D!");
        while (runCond) {
            System.out.println("What would you like to do?");
            System.out.println("1 - Encode");
            System.out.println("2 - Decode");
            System.out.println("3 - Quit");
            int option = kb.nextInt();
            if (option == 1) {
                System.out.println("\nWhat would you like to encode? ");
                String word = kb2.nextLine();
                char c1 = word.charAt(0);
                char c2 = word.charAt(1);
                char c3 = word.charAt(2);
                char c4 = word.charAt(3);
                char c5 = word.charAt(4);
                c2 = (char) (c2 + 4);
                c3 = (char) (c3 - 4);
                char temp = c4;
                c4 = c5;
                c5 = temp;
                System.out.println("Result: " + c1 + c2 + c3 + c4 + c5 + "\n");
            } else if (option == 2) {
                System.out.println("\nWhat would you like to decode? ");
                String word = kb2.nextLine();
                char c1 = word.charAt(0);
                char c2 = word.charAt(1);
                char c3 = word.charAt(2);
                char c4 = word.charAt(3);
                char c5 = word.charAt(4);
                c2 = (char) (c2 - 4);
                c3 = (char) (c3 + 4);
                char temp = c4;
                c4 = c5;
                c5 = temp;
                System.out.println("Result: " + c1 + c2 + c3 + c4 + c5 + "\n");
            } else {
                System.out.print("\nBye :D!");
                runCond = false;
            }
        }
    }
}