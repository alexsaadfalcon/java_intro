import java.io.*;
import java.util.*;

public class GPACalc {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("A Credit Hours: ");
        double a = kb.nextInt(); //make A a double to not cause integer division
        System.out.print("B Credit Hours: ");
        int b = kb.nextInt();
        System.out.print("C Credit Hours: ");
        int c = kb.nextInt();
        System.out.print("D Credit Hours: ");
        int d = kb.nextInt();
        System.out.print("F Credit Hours: ");
        int f = kb.nextInt();
        double GPA = (4 * a + 3 * b + 2 * c + 1 * d) / (a + b + c + d + f);
        System.out.println("GPA: " + GPA);
    }
}