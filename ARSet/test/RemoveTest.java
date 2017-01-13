/**
 * Created by aleksandarbabunovic on 2017-01-13.
 */

import org.junit.Before;
import org.junit.Assert;
import org.junit.After;
import org.junit.Test;

public class RemoveTest {

    private ARSet testSet;

    @Before
    public void init(){
        testSet = new ARSet();
        testSet.add(1);
        testSet.add(2);
        testSet.add(3);
    }

    @Test
    public void removeFailTest(){
        Assert.assertEquals(testSet.remove(4),false);
        Assert.assertArrayEquals(testSet.toArray(),new int[]{1,2,3});
    }

    @Test
    public void removeFirstElemTest(){
        Assert.assertEquals(testSet.remove(1),true);
        Assert.assertArrayEquals(testSet.toArray(),new int[]{2,3});
    }

    @Test
    public void removeSucceedTest(){
        Assert.assertEquals(testSet.remove(3),true);
        Assert.assertArrayEquals(testSet.toArray(),new int[]{1,2});
    }
}
