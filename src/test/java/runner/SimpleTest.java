package runner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(MyJunitRunner.class)
public class SimpleTest {



    @BeforeClass
    public static void beforeClass(){
        System.out.println(" beforeClass running!!!!");
    }

    @Before
    public void before(){
        System.out.println(" before running!!!!");
    }

    @Test
    public void simpleTest(){
        Assert.assertEquals(1,1);
    }
}
