//I worked on this with Mahalakshmi Srinivasan
/**
* An Exception when the user's party is full in Adventure
* Unchecked Error
* @author Alexander Saad-Falcon
* @version 1.0.0.0
*/
public class PartyIsFullException extends RuntimeException {

    /**
    * Instantiates a PartyIsFullException with no args
    */
    public PartyIsFullException() {
        super("Your party is full");
    }

    /**
    * Instantiates a PartyIsFullException
    * @param s The error message
    */
    public PartyIsFullException(String s) {
        super(s);
    }
}