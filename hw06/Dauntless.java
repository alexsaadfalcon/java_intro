import java.util.Random;
import java.util.Scanner;

//I worked on this with Mahalakshmi Srinivasan
/**
* A Dauntlesss Person in the world of Divergent
*@author Alex Saad-Falcon
*@version 1.0
*/
public class Dauntless extends Factioned {
    protected int agility;
    protected int endurance;
    private Dauntless rival;

    /**
    *Creates an instance of the Dauntless class with no args
    */
    public Dauntless() {
        super(Faction.DAUNTLESS);
        agility = 5;
        endurance = 5;
    }

    /**
    *Creates an instance of the Dauntless class
    *@param p A Person to create a Dauntless out of
    */
    public Dauntless(Person p) {
        this(p.getFirstName(), p.getLastName(),
            p.getAge());
    }

    /**
    *Creates an instance of the Dauntless class
    *@param p A Person to create a Dauntless out of
    *@param agility The Dauntless' agility
    *@param endurance The Dauntless' endurance
    */
    public Dauntless(Person p, int agility, int endurance) {
        this(p.getFirstName(), p.getLastName(),
            p.getAge(), agility, endurance);
    }

    /**
    *Creates an instance of the Dauntless class
    *@param firstName The Dauntless Person's first name
    *@param lastName The Dauntless Person's last name
    *@param age The Dauntless Person's age
    */
    public Dauntless(String firstName, String lastName, int age) {
        this(firstName, lastName, age, 5, 5);
    }

    /**
    *Creates an instance of the Dauntless class
    *@param firstName The Dauntless Person's first name
    *@param lastName The Dauntless Person's last name
    *@param age The Dauntless Person's age
    *@param agility The Dauntless' agility
    *@param endurance The Dauntless' endurance
    */
    public Dauntless(String firstName, String lastName, int age,
        int agility, int endurance) {
        super(firstName, lastName, age, Faction.DAUNTLESS);
        this.agility = checkStat(agility);
        this.endurance = checkStat(endurance);
    }

    /**
    * Compares Dauntless a (the one calling the method) to Person p
    * Compares sum of agility and endurance for both Dauntless,
    * or returns Person's compareTo if p is not a Dauntless
    * @param p A Person to compare Dauntless a to
    * @return Difference in agility + endurance if p is Dauntless
    */
    public int compareTo(Person p) {
        if (p instanceof Dauntless) {
            Dauntless d = (Dauntless) p;
            return (agility + endurance) - (d.agility + d.endurance);
        }
        return super.compareTo(p);
    }

    /**
    * Has Dauntless a compete with Dauntless d. The winner is determined
    * by Random number generation, with a Dauntless of -3 compared to another
    * one stil having a small chance to beat the greater Dauntless
    * The loser gets the winner as a rival
    * Runs recursively until there is a winner
    * @param d The Dauntless this is competing against
    * @return The winner
    */
    public Dauntless compete(Dauntless d) {
        int chance = this.compareTo(d);
        Random gen = new Random();
        chance += gen.nextInt(7) - 3; //Adds int from [-3,3]
        if (chance > 0) {
            d.rival = this;
            return this;
        } else if (chance < 0) {
            rival = d;
            return d;
        } else {
            return this.compete(d); //recursively competes till a winner
        }
    }

    /**
    * Takes user input for Dauntless to train
    * Depending on user input increases one stat by a random number
    * from 0 to 1, 2, or 4
    */
    public void train() {
        Scanner kb = new Scanner(System.in);
        Random gen = new Random();
        System.out.print("What is " + firstName + " " + lastName
            + " going to train?" + " (Agility or Endurance) ");
        String stat = kb.nextLine();
        stat = stat.toLowerCase();
        boolean ifAgility = 'a' == stat.charAt(0);
        System.out.print("How hard is he/she going to train?"
            + " (Not hard, Medium, Hard) ");
        String howHard = kb.nextLine();
        howHard = howHard.toLowerCase();
        int increment = 0;
        switch (howHard.charAt(0)) {
        case 'n':
            increment = gen.nextInt(2);
            break;
        case 'm':
            increment = gen.nextInt(3);
            break;
        case 'h':
            increment = gen.nextInt(5);
            break;
        default:
            increment = gen.nextInt(2);
            break;
        }
        if (ifAgility) {
            this.trainAgility(increment);
        } else {
            this.trainEndurance(increment);
        }
        if (rival != null) {
            System.out.println(firstName + " " + lastName + " may be"
                + " able to beat " + rival.firstName + " " + rival.lastName
                + " now.");
        }
    }

    /**
    * Raises agility by a set amount
    * @param i The amount to increase agility by
    */
    public void trainAgility(int i) {
        agility = checkStat(agility + i);
    }

    /**
    * Raises endurance by a set amount
    * @param i The amount to increase endurance by
    */
    public void trainEndurance(int i) {
        endurance = checkStat(endurance + i);
    }

    /**
    * Sets the rival of a Dauntless to the input
    * @param d The rival to set to
    */
    public void setRival(Dauntless d) {
        rival = d;
    }

    /**
    * Gives the Dauntless that is this Dauntless' rival
    * @return The rival
    */
    public Dauntless getRival() {
        return rival;
    }

    /**
    * Gives the Dauntless' agility
    * @return The agility
    */
    public int getAgility() {
        return agility;
    }

    /**
    * Gives the Dauntless' endurance
    * @return The endurance
    */
    public int getEndurance() {
        return endurance;
    }

    /**
    * Adjusts agility or endurance to correct range (0-10)
    * @param stat The stat to adjust
    * @return The adjusted stat
    */
    private int checkStat(int stat) {
        if (stat < 0) {
            return 0;
        } else if (stat > 10) {
            return 10;
        }
        return stat;
    }

    /**
    * What is shown when a Dauntless Person is printed out.
    * Adds agility and endurance to Factioned's toString()
    * @return a String with the Dauntless Person's details
    */
    public String toString() {
        return super.toString() + ", Agility " + agility
            + ", Endurance " + endurance;
    }
}