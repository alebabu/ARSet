/**
 * Created by aleksandarbabunovic on 2017-01-13.
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * A set of Integers that does not allow duplicates.
 */
public class ARSet implements Iterable<Integer>{

    public static void main(String[] args) {
    }

    /**
     * Implementation is done through delegation.
     */
    private LinkedList<Integer> elems;

    /**
     * Simply initiates the LinkedList<Integer> Elems.
     */
    public ARSet() {
        elems = new LinkedList<>();
    }

    /**
     * Adds an integer to the set. If the integer is already present in the set, the set is left unchanged.
     * @param i is the integer to be added.
     */
    public void add(Integer i) {
        if(!elems.contains(i)) {
            elems.add(i);
        }
    }

    /**
     * Deletes an integer from the set. If the integer is not present in the set, the set is left unchanged.
     * @param i is the integer to be added.
     */
    public void delete(Integer i) {
        elems.remove(i);
    }

    /**
     * Creates a new set which is the union of the set it is called upon and the set that is supplied.
     * Both the set it is called upon and the set that is supplied are left unchanged.
     * @param set is the set that is supplied.
     * @return a new set that is the union of the two sets.
     */
    public ARSet union(ARSet set) {
        ARSet newset = new ARSet();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            Integer i = iterator.next();
            if(!elems.contains(i)) {
                newset.add(i);
            }
        }
        iterator = this.iterator();
        while(iterator.hasNext()) {
            newset.add(iterator.next());
        }
        return newset;
    }

    /**
     * Creates a new set which is the intersection of the set it is called upon and the set that is supplied.
     * Both the set it is called upon and the set that is supplied are left unchanged.
     * @param set is the set that is supplied.
     * @return a new set that is the union of the two sets.
     */
    public ARSet intersection(ARSet set) {
        ARSet newset = new ARSet();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            Integer i = iterator.next();
            if(elems.contains(i)) {
                newset.add(i);
            }
        }
        return newset;
    }

    /* Boiler-plate stuff to be able to iterate over the set. Not of interest to students. */

    @Override
    public Iterator<Integer> iterator() {
        return new ARSetIterator(this);
    }

    private class ARSetIterator implements Iterator<Integer> {

        private ARSet set;
        private int current;

        public ARSetIterator(ARSet set) {
            this.set = set;
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < set.elems.size() - 1;
        }

        @Override
        public Integer next() {
            if(hasNext()) {
                return set.elems.get(current++);
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
