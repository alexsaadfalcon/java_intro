//I worked on this with Mahalakshmi Srinivasan
/**
* An abstract class for a Person in the world of Divergent
*@author Alex Saad-Falcon
*@version 1.0
*/
public abstract class Person implements Comparable<Person> {
    /** The first name of the Person */
    protected String firstName;
    /** The last name of the Person */
    protected String lastName;
    /** The Person's age */
    protected int age;
    /** The Factions a Person can belong to */
    public enum Faction { AMITY, ABNIGATION, DAUNTLESS, ERUDITE, CANDOR };

    /**
    * Creates an instance of the Person class with no args
    *Note this is an abstract class, so it serves
    *for super calls
    */
    public Person() {
        this("Thomas", "Lilly", 300);
    }

    /**
    *Creates an instance of the Person class via copy constructor
    *@param p A Person to copy
    */
    public Person(Person p) {
        this(p.firstName, p.lastName, p.age);
    }

    /**
    *Creates an instance of the Person class
    *@param firstName The Person's first name
    *@param lastName The Person's last name
    *@param age The Person's age
    */
    public Person(String firstName, String lastName, int age) {
        if (firstName != null) {
            this.firstName = firstName;
        } else {
            this.firstName = "Thomas";
        }
        if (lastName != null) {
            this.lastName = lastName;
        } else {
            this.lastName = "Lilly";
        }
        this.age = age;
    }

    /**
    * Gives the first name of the Person
    * @return the first name
    */
    public String getFirstName() {
        return firstName;
    }

    /**
    * Gives the last name of the Person
    * @return the last name
    */
    public String getLastName() {
        return lastName;
    }

    /**
    * Gives the age of the Person
    * @return the age
    */
    public int getAge() {
        return age;
    }

    /**
    * Sets the first name of the Person to the input
    * @param f The first name to set to
    */
    public void setFirstName(String f) {
        if (firstName != null) {
            this.firstName = f;
        } else {
            this.firstName = "Thomas";
        }
    }

    /**
    * Sets the last name of the Person to the input
    * @param l The last name to set to
    */
    public void setLastName(String l) {
        if (lastName != null) {
            this.lastName = l;
        } else {
            this.lastName = "Lilly";
        }
    }

    /**
    * Sets the age of the Person to the input
    * @param a The age to set to
    */
    public void setAge(int a) {
        this.age = a;
    }

    /**
    * Tests to see if a Person and an object are equal
    * Only returns true if o is a Person with the same name and age
    * @param o The Object to compare equivalency to
    * @return true if Person a == Person b
    */
    public boolean equals(Object o) {
        // Using instanceof so all person subclasses can be checked
        if (o instanceof Person) {
            Person p = (Person) o;
            if (firstName != null && lastName != null
                && p.firstName != null && p.lastName != null) {
                return (firstName.equals(p.firstName))
                    && (lastName.equals(p.lastName))
                    && (age == p.age);
            }
        }
        return false;
    }

    /**
    * Compares Person a (the one calling the method) to Person p
    * @param p A Person to compare Person a to
    * @return If Person a is greater than, less than, or equal to p
    */
    public int compareTo(Person p) {
        int diff = 0;
        diff = age - p.age;
        if (firstName != null && lastName != null
            && p.firstName != null && p.lastName != null) {
            if (diff == 0) {
                diff = lastName.compareTo(p.lastName);
                if (diff == 0) {
                    diff = firstName.compareTo(p.firstName);
                }
            }
        }
        return diff;
    }

    /**
    * What is shown when a Person is printed out.
    * First and last name, in addition to age
    * @return a String with the Person's details
    */
    public String toString() {
        return firstName + " " + lastName + ", Age " + age;
    }
}