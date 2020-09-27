import java.util.Set;

/**
 *Extended Set where additional functionality is added
 *
 * @author Matt Gruchacz
 * @version 4 3/23/14
 */

public interface ExtendedSet<T> extends Set<T> {

    /**
     *Calculates the set union with the given input
     *http://en.wikipedia.org/wiki/Union_%28set_theory%29
     * @param set - the set to perform the operation along with
     * @return  the set representing the invoked set and the parameter
     */
    ExtendedSet<T> union(ExtendedSet<T> set);

    /**
     *Calculates the set intersection with the given input
     *http://en.wikipedia.org/wiki/Intersection_%28set_theory%29
     * @param set - the set to perform the operation along with
     * @return the set representing the intersection
     *         of the invoked set and the parameter
     */
    ExtendedSet<T> intersection(ExtendedSet<T> set);

    /**
     *Calculates the set difference with the given input
     * http://en.wikipedia.org/wiki/Complement_(set_theory)#Relative_complement
     * @param set - the set to perform the operation along with
     * @return the set representing the difference of the
     *         invoked set and the parameter
     */
    ExtendedSet<T> difference(ExtendedSet<T> set);

    /**
     *Calculates the symmetric set difference with the given input
     * See http://en.wikipedia.org/wiki/Symmetric_difference for definition
     * @param set - the set to perform the operation along with
     * @return the set representing the difference
     *         of the invoked set and the parameter
     */
    ExtendedSet<T> symmetricDifference(ExtendedSet<T> set);

    /**
     *Calculates the powerset
     * http://en.wikipedia.org/wiki/Power_set
     * @return the set representing the powerset of the invoked set
     */
    ExtendedSet<ExtendedSet<T>> powerSet();


    /**
     *Calculates the CartesianProduct
     * http://en.wikipedia.org/wiki/Cartesian_product
     * @param set - the set to perform the operation along with
     * @return the set representing the cartesian product of the method
     *         invoked and the parameter
     */
    ExtendedSet<Tuple<T>> product(ExtendedSet<T> set);

    /**
      *Maps every element of the set to a new set using
      *the parameter and returns the new set.  Does not
      *change the original set;
      *
      *@param <E> the type we are mapping to from T
      *@param map - the object used to map elements
      *@return the set containing the mapped elements
      */
    <E> ExtendedSet<E> map(LMap<T, E> map);

    /**
      *Reduces all of the elements of the set to a single element
      *by successfive calls of reduce
      *Note: we do not change the original set only create a new set
      *@param reduce - the object to use to decide which elements
      *       to filter
      *@return T - the element as a result of success calls on the reduce
      *        method
      */
    T reduce(LReduce<T> reduce);

    /**
      *Creates a new set containing filtered elements where
      *if the parameter returns true, you keep the element
      *Note: we do not change the orginal set, only create a new set
      *
      *@param filter- the object to help filter elements in the set
      *@return ExtendedSet - the set of filtered elements
      */
    ExtendedSet<T> filter(LFilter<T> filter);


    /**
      *Although there is a default equals method,
      *you must write a valid equals method for your
      *set
      *
      *@param o - the object to check equality
      *@return boolean - whether or not the objects are equal
      */
    @Override
    boolean equals(Object o);

}