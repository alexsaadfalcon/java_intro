//I worked on this with Mahalakshmi Srinivasan
import java.io.FileNotFoundException;

/**
* An Exception when the user's input for a list of Pokemon doesn't exist
* Checked Error
* @author Alexander Saad-Falcon
* @version 1.0.0.0
*/
public class UnknownRegionException extends FileNotFoundException {

    /**
    * Instantiates an UnknownRegionException with no args
    */
    public UnknownRegionException() {
         super("Could not find your region!");
    }
}