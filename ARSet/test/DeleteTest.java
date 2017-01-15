/**
 * Created by aleksandarbabunovic on 2017-01-14.
 */
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class DeleteTest {
    private ARSet set;

    @Before
    public void init(){
        set = new ARSet();
        set.add(1);
    }

    @Test
    public void deleteTest(){
        set.delete(1);
        assertArrayEquals(new int[]{}, set.toArray());
    }
}
