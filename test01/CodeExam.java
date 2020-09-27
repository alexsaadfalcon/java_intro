/*
* PLEASE FILL OUT THE FOLLOWING INFORMATION
* Your Name: Alex Saad-Falcon
* Recitation Time: 4:30-6:00
*/
import java.util.Scanner;

public class CodeExam {
    public static void main(String[] args) {
        char user = 'y';
        while (user == 'y') {
            Scanner kb = new Scanner(System.in);
            System.out.println("Please enter a string:");
            String str = kb.nextLine();
            System.out.println("\nPlease enter the character to count:");
            String temp = kb.nextLine();
            char c = temp.charAt(0);
            int counter = 0;
            int dotCounter = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == c) {
                    counter++;
                }
                if (str.charAt(i) == '.') {
                    dotCounter++;
                }
            }
            System.out.println("\nThe period character appears "
                + dotCounter + " times.");
            System.out.println("The '" + c + "' character appears "
                + counter + " times.\n");
            System.out.println("Do you want to enter another sentence?");
            temp = kb.nextLine();
            user = temp.charAt(0);
            System.out.println();
        }
        System.out.println("Good bye.");
    }
}