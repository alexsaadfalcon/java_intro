/**
  * Functional Interface responsible to reduce
  * to two elements to a single element
  * a idea similar to (a, b) = c
  *@param <T> the type of elements being reduced
  *@author Matt Gruchacz
  *@version 4 - 3/23/14
  */
@FunctionalInterface
public interface LReduce<T> {
    /**
      * Reduces the two given inputs to a single output of the same type
      *@param a the first element to reduce
      *@param b the second element to reduce
      *@return T the result of reducing the two parameters
      */
    T reduce(T a, T b);
}