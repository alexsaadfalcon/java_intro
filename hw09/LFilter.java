/**
  *FunctionalInterface that aids in filtering elements
  *@param <T> the type that is being filtered
  *@author Matt Gruchacz
  *@version 4 - 3/23/14
  */
@FunctionalInterface
public interface LFilter<T> {
    /**
     *Decides whether or not the element should be filtered
     *@param a - the element to determine if it should be filtered
     *       or not
     *@return boolean - wether the element should be kept or not,
     *        a returning true means the element should be kept
     */
    boolean filter(T a);
}