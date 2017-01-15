/**
 * Created by aleksandarbabunovic & Robert Kent Krook on 2017-01-13.
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
     * Adds all the integers in an array to the set. If any of the integers already exists in the set then it is not
     * added.
     * @param elems is the array of integers to be added.
     */
    public void add(Integer[] elems) {
        for (Integer i : elems) {
            add(i);
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

    /**
     * Checks whether the supplied set is a subset of the set upon which it is called. Returns true if it is, false if it is not.
     * @param set is the set that is supplied.
     * @return boolean true if it is a subset of the set it is called upon, else false.
     */
    public boolean isSubset(ARSet set) {
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            if(!elems.contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    /* Boiler-plate stuff to be able to iterate over the set. Not of interest to students. */

    @Override
    public Iterator<Integer> iterator() {
        return new ARSetIterator(this);
    }

    public int[] toArray(){
        int res[] = new int[elems.size()];
        int i = 0;
        for(Integer elem : elems){
            res[i] = elem;
            i++;
        }
        return res;
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
            return current < set.elems.size();
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