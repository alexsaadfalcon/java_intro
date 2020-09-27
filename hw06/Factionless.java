//I worked on this with Mahalakshmi Srinivasan
/**
* A Factionless Person in the world of Divergent
*@author Alex Saad-Falcon
*@version 1.0
*/
public class Factionless extends Person {
    protected int dangerLevel;

    /**
    *Creates an instance of the Factionless class with no args
    */
    public Factionless() {
        this(50);
    }

    /**
    *Creates an instance of the Factionless class
    *@param dangerLevel The Factionless' danger level
    */
    public Factionless(int dangerLevel) {
        super();
        this.dangerLevel = roundDangerLevel(dangerLevel);
    }

    /**
    *Creates an instance of the Factionless class
    *@param p The Person to create a Factionless out of
    *@param dangerLevel The danger level
    */
    public Factionless(Person p, int dangerLevel) {
        this(p.getFirstName(), p.getLastName(),
            p.getAge(), dangerLevel);
    }

    /**
    *Creates an instance of the Factionless class
    *@param firstName The Factionless' first name
    *@param lastName The Factionless' last name
    *@param age The Factionless' age
    *@param dangerLevel The danger level
    */
    public Factionless(String firstName, String lastName,
        int age, int dangerLevel) {
        super(firstName, lastName, age);
        this.dangerLevel = roundDangerLevel(dangerLevel);
    }

    // Getters and Setters

    /**
    * Gets the Factionless' danger level
    * @return the danger level
    */
    public int getDangerLevel() {
        return dangerLevel;
    }

    /**
    * Sets the Factionless' danger level
    * @param newDangerLevel the danger level to set to
    */
    public void setDangerLevel(int newDangerLevel) {
        dangerLevel = roundDangerLevel(newDangerLevel);
    }

    /**
    * What is shown when a Factionless Person is printed out.
    * Adds danger level to Person's toString()
    * @return a String with the Factionless Person's details
    */
    public String toString() {
        return super.toString() + ", Factionless, Danger Level " + dangerLevel;
    }

    /**
    * Rounds danger level to appropriate range (private)
    * @param level The level to round
    * @return the rounded level
    */
    private int roundDangerLevel(int level) {
        if (level < 0) {
            return 0;
        } else if (level > 50) {
            return 50;
        }
        return level;
    }
}