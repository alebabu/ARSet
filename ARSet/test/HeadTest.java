/**
 * Created by aleksandarbabunovic on 2017-01-13.
 */

import org.junit.Before;
import org.junit.Assert;
import org.junit.After;
import org.junit.Test;

public class HeadTest {

    private ARSet testSet;

    @Before
    public void init(){
        testSet = new ARSet();
        testSet.add(1);
        testSet.add(2);
        testSet.add(3);
    }

    @Test
    public void getHeadTest(){
        int test = testSet.head();
        Assert.assertEquals(test, 1);
    }
}
