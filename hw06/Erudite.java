//I worked on this with Mahalakshmi Srinivasan
/**
* An Erudite Person in the world of Divergent
*@author Alex Saad-Falcon
*@version 1.0
*/
public class Erudite extends Factioned {
    protected String university;
    protected String major;
    protected String[] books;

    /**
    *Creates an instance of the Erudite class with no args
    */
    public Erudite() {
        super(Faction.ERUDITE);
        university = "Georgia Tech";
        major = "Computer Science";
        books = new String[]{"Some Java Book"};
    }

    /**
    *Creates an instance of the Erudite class
    *@param p The Person to make into an erudite
    */
    public Erudite(Person p) {
        this(p.getFirstName(), p.getLastName(),
            p.getAge());
    }

    /**
    *Creates an instance of the Erudite class
    *@param p The Person to make into an Erudite
    *@param university The University the Erudite goes to
    *@param major The major of the Erudite
    *@param books A String array of the books the Erudite has read
    */
    public Erudite(Person p, String university,
        String major, String[] books) {
        this(p.getFirstName(), p.getLastName(),
            p.getAge(), university, major, books);
    }

    /**
    *Creates an instance of the Erudite class
    *@param firstName The Erudite Person's first name
    *@param lastName The Erudite Person's last name
    *@param age The Erudite Person's age
    */
    public Erudite(String firstName, String lastName, int age) {
        this(firstName, lastName, age, "Georgia Tech",
            "Computer Science", new String[]{"Some Java Book"});
    }

    /**
    *Creates an instance of the Erudite class
    *@param firstName The Erudite Person's first name
    *@param lastName The Erudite Person's last name
    *@param age The Erudite Person's age
    *@param university The University the Erudite goes to
    *@param major The major of the Erudite
    *@param books A String array of the books the Erudite has read
    */
    public Erudite(String firstName, String lastName, int age,
        String university, String major, String[] books) {
        super(firstName, lastName, age, Faction.ERUDITE);
        if (university != null) {
            this.university = university;
        } else {
            this.university = "Georgia Tech";
        }
        if (major != null) {
            this.major = major;
        } else {
            this.major = "Computer Science";
        }
        if (books != null) {
            this.books = books;
        } else {
            this.books = new String[]{"Some Java Book"};
        }
    }

    /**
    * Tests to see if an Erudite and an object are equal
    * Only returns true if o is an Erudite with the same name, age,
    * university, and major, or if o is a Person with the same name
    * and age
    * @param o The Object to compare equivalency to
    * @return true if Erudite a == Erudte e or Erudite a = Person p
    */
    public boolean equals(Object o) {
        if (o instanceof Erudite) {
            Erudite e = (Erudite) o;
            if (university != null && major != null
                && e.university != null && e.major != null) {
                return super.equals(e)
                    && (university.equals(e.university))
                    && (major.equals(e.major));
            } else {
                return false;
            }
        } else {
            return super.equals(o);
        }
    }

    /**
    * Compares Erudite a (the one calling the method) to Person p
    * Compares book counts for two Erudites,
    * or returns Person's compareTo() if p is not an Erudite
    * (compares age and name)
    * @param p A Person to compare Erudite a to
    *@return Difference in bookcounts if p is Erudite, Person's compareTo if not
    */
    public int compareTo(Person p) {
        if (p instanceof Erudite) {
            Erudite e = (Erudite) p;
            return (books.length) - (e.books.length);
        }
        return super.compareTo(p);
    }

    /**
    * Sets the Erudite's university to the input
    * @param u The university to set to
    */
    public void setUniversity(String u) {
        if (university != null) {
            this.university = u;
        } else {
            this.university = "Georgia Tech";
        }
    }

    /**
    * Sets the Erudite's major to the input
    * @param m The major to set to
    */
    public void setMajor(String m) {
        if (major != null) {
            this.major = m;
        } else {
            this.major = "Computer Science";
        }
    }

    /**
    * Sets the Erudite's book list to the input
    * @param b The book list to set to
    */
    public void setBooks(String[] b) {
        if (books != null) {
            this.books = b;
        } else {
            this.books = new String[]{"Some Java Book"};
        }
    }

    /**
    * Gives the university of the Erudite
    * @return The university
    */
    public String getUniversity() {
        return university;
    }

    /**
    * Gives the major of the Erudite
    * @return The major
    */
    public String getMajor() {
        return major;
    }

    /**
    * What is shown when an Erudite Person is printed out.
    * Adds university, major, and book count to Factioned's toString()
    * @return a String with the Erudite Person's details
    */
    public String toString() {
        return super.toString() + ", University: " + university
            + ", Major: " + major + ", Book Number: " + books.length;
    }
}