/**
 * Created by aleksandarbabunovic on 2017-01-14.
 */
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class AddTest {
    private ARSet set;

    @Before
    public void init(){
        set = new ARSet();
    }

    @Test
    public void addTest(){
        set.add(1);
        assertArrayEquals(new int[]{1}, set.toArray());
    }

    @Test
    public void addArrayTest(){
        Integer elems[] = new Integer[]{1,2,3,4,5};
        set.add(elems);
        assertArrayEquals(new int[]{1,2,3,4,5}, set.toArray());
    }

    @Test
    public void addSameElements(){
        Integer elems[] = new Integer[]{1,1,1,1,1};
        set.add(elems);
        assertArrayEquals(new int[]{1}, set.toArray());
    }
}
