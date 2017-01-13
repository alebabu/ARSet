/**
 * Created by aleksandarbabunovic on 2017-01-13.
 */
import org.junit.Before;
import org.junit.Assert;
import org.junit.After;
import org.junit.Test;

public class AddTest {

    private ARSet testSet;

    @Before
    public void init(){
        testSet = new ARSet();
        testSet.add(1);
        testSet.add(2);
        testSet.add(3);
    }

    @Test
    public void addSucceedTest(){
        testSet.add(4);
        Assert.assertArrayEquals(testSet.toArray(),new int[]{1,2,3,4});
    }

    @Test
    public void addFailTest(){
        testSet.add(3);
        Assert.assertArrayEquals(testSet.toArray(),new int[]{1,2,3});
    }

}
