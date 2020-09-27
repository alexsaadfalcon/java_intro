/**
 *Tuple represents an ordered pairing of
 * A and B elements of the generic type
 * @param <T> the type that the tuple will contain
 * @author Matt Gruchacz
 * @version 4 3/23/14
 */

public interface Tuple<T> {
    /**
     *Gets the first element of the tuple
     *@return the first element of the tuple
     */
    T getA();

    /**
     *Gets the second element of the tuple
     *@return the second element of the tuple
     */
    T getB();
}