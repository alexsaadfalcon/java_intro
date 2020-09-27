//I worked on this with Mahalakshmi Srinivasan
/**
* An abstract class for a Factioned Person in the world of Divergent
*@author Alex Saad-Falcon
*@version 1.0
*/
public abstract class Factioned extends Person {
    protected Faction faction;

    /**
    *Creates an instance of the Factioned class with no args
    *Note this is also an abstract class, so it serves
    *for super calls
    */
    public Factioned() {
        this(Faction.ERUDITE);
    }

    /**
    *Creates an instance of the Factioned class
    *@param faction The Factioned Person's faction
    */
    public Factioned(Faction faction) {
        super();
        if (faction != null) {
            this.faction = faction;
        } else {
            this.faction = Faction.ERUDITE;
        }
    }

    /**
    *Creates an instance of the Factioned class
    *@param p A Person to copy into the constructor
    *@param faction The Factioned Person's faction
    */
    public Factioned(Person p, Faction faction) {
        this(p.getFirstName(), p.getLastName(),
            p.getAge(), faction);
    }

    /**
    *Creates an instance of the Factioned class
    *@param firstName The Factioned Person's first name
    *@param lastName The Factioned Person's last name
    *@param age The Factioned Person's age
    *@param faction The Factioned Person's faction
    */
    public Factioned(String firstName, String lastName,
        int age, Faction faction) {
        super(firstName, lastName, age);
        if (faction != null) {
            this.faction = faction;
        } else {
            this.faction = Faction.ERUDITE;
        }
    }

    //Getters and Setters
    /**
    * Getter for the Factioned Person's Faction
    * @return The Faction
    */
    public Faction getFaction() {
        return faction;
    }

    /**
    * What is shown when a Factioned Person is printed out.
    * Adds faction to Person's toString()
    * @return a String with the Factioned Person's details
    */
    public String toString() {
        return super.toString() + ", Faction " + faction;
    }
}