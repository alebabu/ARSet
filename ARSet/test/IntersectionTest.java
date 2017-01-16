/**
 * Created by aleksandarbabunovic on 2017-01-14.
 */
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class IntersectionTest {
    private ARSet set0;
    private ARSet set1;
    private ARSet set2;

    @Before
    public void init(){
        set0 = new ARSet();
        set1 = new ARSet();
        set2 = new ARSet();
        set0.add(new Integer[]{1,2,3,4});
        set1.add(new Integer[]{5,6,1});
        set2.add(new Integer[]{4,5,7,8,1});
    }

    @Test
    public void intersectionTest1(){
        ARSet newSet = set0.intersection(set1);
        assertArrayEquals(new int[]{1}, newSet.toArray());
    }

    @Test
    public void intersectionTest2(){
        ARSet newSet = set1.intersection(set0);
        assertArrayEquals(new int[]{1}, newSet.toArray());
    }

    @Test
    public void intersectionTest3(){
        ARSet newSet = set0.intersection(set2);
        ARSet expected = new ARSet();
        expected.add(new Integer[]{1,4});
        assertEquals(newSet.equals(expected), true);
    }
}
