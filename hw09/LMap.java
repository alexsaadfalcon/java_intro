/**
  *FunctionalInterface that maps elements of type T to type E
  *@param <T> the original type
  *@param <E> the new type
  *@author Matt Gruchacz
  *@version 4 - 3/23/14
  */
@FunctionalInterface
public interface LMap<T, E> {
    /**
      *Maps an element of type T to type E
      *@param element the source element to map from
      *@return E the destination element to map to
      */
    E map(T element);
}