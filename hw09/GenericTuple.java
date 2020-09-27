//I worked on this homework with Mahalakshmi Srinivasan
/**
 * An implementation of a Generic Tuple
 * @author Alexander Saad-Falcon
 * @version 1.0
 * @param <T> The data type held in the Generic Tuple
 */
public class GenericTuple<T> implements Tuple<T> {
    /**
     * The first element in the Tuple
     */
    private T first;

    /**
     * The second element in the Tuple
     */
    private T second;

    /**
     * Creates a Tuple of Ts, given the first and second elements
     * @param first The first element in the Tuple
     * @param second The second element in the Tuple
     */
    public GenericTuple(T first, T second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public T getA() {
        return first;
    }

    @Override
    public T getB() {
        return second;
    }
}
