/**
 * Created by aleksandarbabunovic on 2017-01-14.
 */
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class IsSubsetTest {
    private ARSet set0;
    private ARSet set1;
    private ARSet set2;

    @Before
    public void init(){
        set0 = new ARSet();
        set1 = new ARSet();
        set2 = new ARSet();
        set0.add(new Integer[]{1,2,3});
        set1.add(new Integer[]{1,2,3,4});
        set2.add(new Integer[]{5,6});
    }

    @Test
    public void isASubSetTest(){
        boolean test = set1.isSubset(set0);
        assertEquals(true, test);
    }

    @Test
    public void isNotASubSetTest(){
        boolean test = set0.isSubset(set2);
        assertEquals(false, test);
    }

    @Test
    public void isNotASubSetTest2(){
        boolean test = set0.isSubset(set1);
        assertEquals(false, test);
    }
}
