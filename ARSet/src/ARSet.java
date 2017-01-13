/**
 * Created by aleksandarbabunovic on 2017-01-13.
 */

/**
 * A set of Elements E that does not allow duplicates.
 */
public class ARSet {

    private LinkedList list;
    private int capacity;

    public ARSet(){
        list = null;
        capacity = 0;
    }

    public boolean add(int elem){
        if (list == null){
            list = new LinkedList(elem,null);
            capacity++;
            return true;
        }
        LinkedList index = list;
        while(index.next != null){
            if(index.next.elem == elem) {
                return false;
            }
            index = index.next;
        }
        index.next = new LinkedList(elem,null);
        capacity++;
        return true;
    }

    public int head(){
        return list.elem;
    }

    public ARSet tail(){
        ARSet res = new ARSet();
        res.capacity = capacity-1;
        LinkedList index = list;
        res.list = new LinkedList(index.next.elem, null);
        LinkedList resIndex = res.list;
        index = index.next;
        while(index.next != null){
            resIndex.next = new LinkedList(index.next.elem, null);
            resIndex = resIndex.next;
            index = index.next;
        }
        return res;
    }

    public boolean remove(int elem){
        LinkedList index = list;
        if(index.elem == elem){
            list = list.next;
            capacity--;
            return true;
        }
        while(index.next != null){
            if(index.next.elem == elem){
                index.next = index.next.next;
                capacity--;
                return true;
            } else {
                index = index.next;
            }
        }
        return false;
    }

    public int[] toArray(){
        int res[] = new int[capacity];
        LinkedList index = list;
        for(int i = 0; i < capacity; i++){
            res[i] = index.elem;
            index = index.next;
        }
        return res;
    }

    private class LinkedList {
        private int elem;
        private LinkedList next;

        private LinkedList(int elem, LinkedList next){
            this.elem = elem;
            this.next = next;
        }
    }
}
