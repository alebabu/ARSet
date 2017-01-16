/**
 * Created by aleksandarbabunovic on 2017-01-14.
 */
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class UnionTest {
    private ARSet set0;
    private ARSet set1;
    private ARSet set2;

    @Before
    public void init(){
        set0 = new ARSet();
        set1 = new ARSet();
        set2 = new ARSet();
        set0.add(new Integer[]{1,2,3});
        set1.add(new Integer[]{4,5,1,2,3});
        set2.add(new Integer[]{6,7,8,9});
    }

    @Test
    public void UnionTest1(){
        ARSet newSet = set0.union(set1);
        ARSet expected = new ARSet();
        expected.add(new Integer[]{1,2,3,4,5});
        assertEquals(newSet.equals(expected), true);
    }

    @Test
    public void UnionTest2(){
        ARSet newSet = set1.union(set2);
        ARSet expected = new ARSet();
        expected.add(new Integer[]{1,2,3,4,5,6,7,8,9});
        assertEquals(newSet.equals(expected), true);
    }

}