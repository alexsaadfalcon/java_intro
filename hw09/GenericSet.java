//I worked on this homework with Mahalakshmi Srinivasan
//import sun.net.www.content.text.Generic;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * An implementation of a Generic Set
 * @author Alexander Saad-Falcon
 * @version 1.0
 * @param <T> The data type held in the Generic Set
 */
public class GenericSet<T> implements ExtendedSet<T> {
    /**
     * The backing structure for GenericSet
     */
    private ArrayList<T> backing;


    /**
     * Instantiates an empty Generic Set
     */
    public GenericSet() {
        backing = new ArrayList<>();
    }

    /**
     * Instantiates a Generic Set by copying another Generic Set
     * @param in The Generic Set to deep copy
     */
    public GenericSet(GenericSet<T> in) {
        backing = new ArrayList<>();
        this.backing.addAll(in);
    }

    //Set methods to implement
    @Override
    public boolean add(T e) { //don't add duplicates
        if (!this.contains(e)) {
            backing.add(e);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        return backing.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return backing.containsAll(c);
    }

    //CHECK
    @Override
    public boolean addAll(Collection<? extends T> c) { //don't add duplicates
        boolean out = false;
        for (T item: c) {
            boolean temp = this.add(item);
            if (temp) {
                out = true;
            }
        }
        return out;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return backing.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return backing.removeAll(c);
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return backing.removeIf(filter);
    }

    @Override
    public void clear() {
        backing.clear();
    }

    @Override
    public int size() {
        return backing.size();
    }

    @Override
    public boolean isEmpty() {
        return backing.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return backing.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return backing.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        backing.forEach(action);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return backing.toArray(a);
    }

    @Override
    public int hashCode() {
        return backing.hashCode();
    }

    @Override
    public Spliterator<T> spliterator() {
        return backing.spliterator();
    }

    @Override
    public Stream<T> stream() {
        return backing.stream();
    }

    @Override
    public Stream<T> parallelStream() {
        return backing.parallelStream();
    }

    @Override
    public String toString() {
        return backing.toString();
    }

    //ExtendedSet methods to implement
    //Done
    @Override
    public ExtendedSet<T> difference(ExtendedSet<T> set) {
        GenericSet<T> out = new GenericSet<>();
        for (T item: backing) {
            if (!set.contains(item)) {
                out.add(item);
            }
        }
        return out;
    }

    //Done I think
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof GenericSet)) {
            return false;
        } else {
            GenericSet g = (GenericSet) o;
            if (g.size() != this.size()) {
                return false;
            } else {
                return this.backing.containsAll((GenericSet) o);
            }
        }
    }

    //Done
    @Override
    public ExtendedSet<T> filter(LFilter<T> filter) {
        ExtendedSet<T> out = new GenericSet<>();
        for (T item: backing) {
            if (filter.filter(item)) {
                out.add(item);
            }
        }
        return out;
    }

    //Done
    @Override
    public ExtendedSet<T> intersection(ExtendedSet<T> set) {
        ExtendedSet<T> out = new GenericSet<>();
        for (T item: backing) {
            if (set.contains(item)) {
                out.add(item);
            }
        }
        return out;
    }

    //Done
    @Override
    public <E> ExtendedSet<E> map(LMap<T, E> map) {
        ExtendedSet<E> out = new GenericSet<>();
        for (T item: backing) {
            out.add(map.map(item));
        }
        return out;
    }

    //CHECK
    @Override
    public ExtendedSet<ExtendedSet<T>> powerSet() {
        return powerCalc(this);
    }

    /**
     * Returns the power set of the Generic Set recur
     * Calculates power set recursively by saying the powerset of a list
     * Is an empty set combined with every element in the powerset of the
     * rest of the list, unioned to with the first element of the list combined
     * with every element in the powerset of rest of the list
     * @param recur Recursive parameter called over and over
     * @return The power set (as well as power subsets)
     */
    private ExtendedSet<ExtendedSet<T>> powerCalc(GenericSet<T> recur) {
        GenericSet<ExtendedSet<T>> out = new GenericSet<ExtendedSet<T>>();
        GenericSet<T> toAdd =  new GenericSet<>();
        if (recur.backing.size() == 1) {
            out.add(toAdd); //empty is always subset
            toAdd.add(recur.backing.get(0));
            out.add(new GenericSet<>(recur));
            return out;
        } else if (recur.backing.size() == 0) {
            out.add(toAdd); //empty is always subset
            return out;
        } else {
            GenericSet<T> rest = new GenericSet<T>();
            for (T item : recur) {
                rest.add(item);
            }
            rest.backing.remove(0);
            ExtendedSet<ExtendedSet<T>> powerRest = powerCalc(rest);
            for (ExtendedSet<T> item : powerRest) {
                toAdd = new GenericSet<>();
                toAdd.add(recur.backing.get(0)); //add subsets w/ first element
                toAdd.addAll(item);
                out.add(toAdd);
            }
            for (ExtendedSet<T> item : powerRest) {
                toAdd = new GenericSet<>(); //add subsets without first element
                toAdd.addAll(item);
                out.add(toAdd);
            }
        }
        return out;
    }

    //Done maybe
    @Override
    public ExtendedSet<Tuple<T>> product(ExtendedSet<T> set) {
        ExtendedSet<Tuple<T>> out = new GenericSet<>();
        for (T item1: this) {
            for (T item2: set) {
                out.add(new GenericTuple<T>(item1, item2));
            }
        }
        return out;
    }

    //Done
    @Override
    public T reduce(LReduce<T> reduce) {
        if (backing.size() == 0) {
            return null;
        } else {
            T end = backing.get(0);
            for (int i = 1; i < backing.size(); i++) {
                end = reduce.reduce(end, backing.get(i));
            }
            return end;
        }
    }

    //Done
    @Override
    public ExtendedSet<T> symmetricDifference(ExtendedSet<T> set) {
        ExtendedSet<T> out = new GenericSet<>();
        for (T item: this) {
            if (!set.contains(item)) {
                out.add(item);
            }
        }
        for (T item: set) {
            if (!this.contains(item)) {
                out.add(item);
            }
        }
        return out;
    }

    //Done maybe
    @Override
    public ExtendedSet<T> union(ExtendedSet<T> set) {
        ExtendedSet<T> out = new GenericSet<>();
        out.addAll(this);
        out.addAll(set);
        return out;
    }

    /*public static void main(String[] args) {
        GenericSet<Integer> ps = new GenericSet<>();
        for (int i = 0; i < 4; i++) {
            ps.add(10 + i);
        }
        ExtendedSet<ExtendedSet<Integer>> powerSet = ps.powerSet();
        System.out.println(powerSet.size());
        for (ExtendedSet<Integer> outer: powerSet) {
            for (int i : outer) {
                System.out.print(i);
            }
            System.out.println();
        }
        if (powerSet.size() == 1024) {
            System.out.println("powerSet size correct");
        } else {
            System.out.println("powerSet size incorrect");
        }
    }*/
}