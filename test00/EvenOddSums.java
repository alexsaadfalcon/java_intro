import java.util.Scanner;

public class EvenOddSums {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        boolean runCondition = true;
        while (runCondition) {
            System.out.print("Please enter the lower bound: ");
            int low = kb.nextInt();
            System.out.print("Please enter the upper bound: ");
            int high = kb.nextInt();
            System.out.println();
            int evenSum = 0;
            int oddSum = 0;
            for (int i = low; i <= high; i += 2) {
                if (low % 2 == 0) {
                    evenSum += i;
                    oddSum += i + 1;
                } else {
                    evenSum += i + 1;
                    oddSum += i;
                }
                if (i == high) { //account for overshooting sum
                    if (low % 2 == 0) {
                        oddSum -= i + 1;
                    } else {
                        evenSum -= i + 1;
                    }
                }
            }
            System.out.println("EvenSum: " + evenSum);
            System.out.println("OddSum: " + oddSum);
            if (low == -1) {
                runCondition = false;
                System.out.print("Bye :D!");
            } else {
                System.out.println();
            }
        }
    }
}
