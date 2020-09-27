import java.util.Scanner;

public class StringConversion {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int out = 0;
        while (out != -1) {
            out = 0;
            System.out.print("Your number: ");
            String x = kb.nextLine();
            int len = x.length();
            if (!(x.charAt(0) == '-')) {
                for (int i = 0; i < len; i++) {
                    out += Character.getNumericValue(x.charAt(i))
                        * Math.pow(10, len - i - 1); //puts each digit in place
                }
                System.out.print("Converted to: " + out + "\n\n");
            } else {
                out = -1;
            }
        }
        System.out.println("Bye!");
    }
}