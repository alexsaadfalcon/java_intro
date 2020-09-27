//I worked on this with Mahalakshmi Srinivasan
/**
* An Exception when an extant Pokemon is added to the Pokedex in Adventure
* Unchecked Error
* @author Alexander Saad-Falcon
* @version 1.0.0.0
*/
public class PokemonAlreadyExistsException extends RuntimeException {

    /**
    * Instantiates a PokemonAlreadyExistsException with no args
    */
    public PokemonAlreadyExistsException() {
        super("Pokemon is already in Pokedex.");
    }

    /**
    * Instantiates a PokemonAlreadyExistsException
    * @param s The error message
    */
    public PokemonAlreadyExistsException(String s) {
        super(s);
    }
}