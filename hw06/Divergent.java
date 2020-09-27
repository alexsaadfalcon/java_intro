import java.util.Random;
import java.util.Scanner;

//I worked on this with Mahalakshmi Srinivasan
/**
* A Factionless Divergent Person in the world of Divergent
*@author Alex Saad-Falcon
*@version 1.0
*/
public class Divergent extends Factionless {
    protected Faction[] factions;
    protected double exposure;
    protected static int numDivergent;

    /**
    *Creates an instance of the Divergent class with no args
    */
    public Divergent() {
        this(new Faction[] {Faction.DAUNTLESS, Faction.ERUDITE});
    }

    /**
    *Creates an instance of the Divergent class
    *@param factions The factions the Divergent fits with
    */
    public Divergent(Faction[] factions) {
        super();
        if (factions != null) {
            this.factions = factions;
        } else {
            this.factions = new Faction[] {Faction.DAUNTLESS, Faction.ERUDITE};
        }
        calculateExposure();
        numDivergent++;
    }

    /**
    *Creates an instance of the Divergent class
    *@param dangerLevel The danger level of the divergent
    */
    public Divergent(int dangerLevel) {
        super(dangerLevel);
        this.factions = new Faction[] {Faction.DAUNTLESS, Faction.ERUDITE};
        calculateExposure();
        numDivergent++;
    }

    /**
    *Creates an instance of the Divergent class
    *@param p The Person to create a Divergent out of
    *@param factions The factions the Divergent fits with
    */
    public Divergent(Person p, Faction[] factions) {
        this(p.getFirstName(), p.getLastName(),
            p.getAge(), factions);
    }

    /**
    *Creates an instance of the Divergent class
    *@param firstName The Factioned Person's first name
    *@param lastName The Factioned Person's last name
    *@param age The Factioned Person's age
    *@param factions The factions the Divergent fits with
    */
    public Divergent(String firstName, String lastName,
        int age, Faction[] factions) {
        this(firstName, lastName, age, 50, factions);
    }

    /**
    *Creates an instance of the Divergent class
    *@param firstName The Factioned Person's first name
    *@param lastName The Factioned Person's last name
    *@param age The Factioned Person's age
    *@param dangerLevel The danger level of the divergent
    *@param factions The factions the Divergent fits with
    */
    public Divergent(String firstName, String lastName,
        int age, int dangerLevel, Faction[] factions) {
        super(firstName, lastName, age, dangerLevel);
        if (factions != null) {
            this.factions = factions;
        } else {
            this.factions = new Faction[] {Faction.DAUNTLESS, Faction.ERUDITE};
        }
        calculateExposure();
        numDivergent++;
    }

    /**
    * Returns a count of the number of Divergents created
    * @return the number of Divergents
    */
    public static int getNumDivergent() {
        return numDivergent;
    }

    /**
    * Calculates the exposure of a Divergent via Random generator
    * Prompts for a name to change the Divergent to if exposure > 1
    */
    public void calculateExposure() {
        Random gen = new Random();
        exposure = gen.nextDouble() * .5 * factions.length;
        if (exposure > 1) {
            Scanner kb = new Scanner(System.in);
            System.out.println("Your Divergent exposure is above 1");
            String first;
            String last;
            do {
                System.out.print("Enter a new name for your "
                    + "Divergent (first last): ");
                first = kb.next();
                last = kb.next();
            } while (first.equals(this.firstName)
                && last.equals(this.lastName));
            this.firstName = first;
            this.lastName = last;
            exposure = 0;
        }
    }

    /**
    * What is shown when a Divergent Person is printed out.
    * Adds exposure and factions to Factionless' toString()
    * @return a String with the Divergent Person's details
    */
    public String toString() {
        String out = String.format(super.toString()
            + ", Divergent, Exposure %.2f, Factions", exposure);
        for (int i = 0; i < factions.length; i++) {
            out = out + " " + factions[i].name();
        }
        return out;
    }
}