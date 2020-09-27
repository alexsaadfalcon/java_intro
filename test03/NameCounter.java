/*
* PLEASE FILL OUT THE FOLLOWING INFORMATION
* Your Name: Alex Saad-Falcon
* Recitation Time: 4:30
*/

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class NameCounter {
    private String[] boyNames;
    private String[] girlNames;
    private int[] boyNum;
    private int[] girlNum;

    public NameCounter() {
        boyNames = new String[1000];
        girlNames = new String[1000];
        boyNum = new int[1000];
        girlNum = new int[1000];
        File in1 = new File("boynames.txt");
        File in2 = new File("girlnames.txt");
        Scanner in = null;
        try {
            in = new Scanner(in1);
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            System.exit(0);
        }

        int counter = 0;
        while (in.hasNext()) {
            boyNames[counter] = in.next();
            boyNum[counter] = Integer.decode(in.next());
            //System.out.println(boyNames[counter]);
            //System.out.println(boyNum[counter]);
            counter++;
        }


        try {
            in = new Scanner(in2);
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            System.exit(0);
        }

        counter = 0;
        while (in.hasNext()) {
            girlNames[counter] = in.next();
            girlNum[counter] = Integer.decode(in.next());
            //System.out.println(girlNames[counter]);
            //System.out.println(girlNum[counter]);
            counter++;
        }
    }
    public void testMatch(String s) {
        boolean inBoy = false;
        boolean inGirl = false;
        for (int i = 0; i < boyNames.length; i++) {
            if (boyNames[i].equalsIgnoreCase(s)) {
                int num = boyNum[i];
                System.out.println(s + " is ranked " + (i + 1)
                    + " in popularity among boys with " + num
                    + " namings.");
                inBoy = true;
            }
            if (girlNames[i].equalsIgnoreCase(s)) {
                int num = girlNum[i];
                System.out.println(s + " is ranked " + (i + 1)
                    + " in popularity among girls with " + num
                    + " namings.");
                inGirl = true;
            }
        }
        if (!inBoy) {
            System.out.println(s + " is not ranked among the top"
                + " 1000 boy names.");
        }
        if (!inGirl) {
            System.out.println(s + " is not ranked among the top"
                + " 1000 girl names.");
        }
    }

    public static void main(String[] args) {
        NameCounter n = new NameCounter();
        //n.testMatch("Zayne");
        //n.testMatch("asdf");
        //n.testMatch("Justice");
        System.out.println("Enter a name to check for popularity."
            + "\nEnter * to exit.");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        while (name.charAt(0) != '*') {
            n.testMatch(name);
            System.out.println("Enter another name.\nEnter * to exit.");
            name = in.next();
        }
        System.out.println("Goodbye!");
    }
}