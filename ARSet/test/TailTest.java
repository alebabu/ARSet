/**
 * Created by aleksandarbabunovic on 2017-01-13.
 */

import org.junit.Before;
import org.junit.Assert;
import org.junit.After;
import org.junit.Test;

public class TailTest {

    private ARSet testSet;

    @Before
    public void init(){
        testSet = new ARSet();
        testSet.add(1);
        testSet.add(2);
        testSet.add(3);
    }

    @Test
    public void tailTest(){
        ARSet tail = testSet.tail();
        Assert.assertArrayEquals(tail.toArray(),new int[]{2,3});
    }
}
