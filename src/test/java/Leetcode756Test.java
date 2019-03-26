import airbnb.Leetcode756;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leetcode756Test {
    @Test
    public void test() {
        Leetcode756 leetcode756 = new Leetcode756();

        String bottom1 = "XYZ";
        List<String> allowed1 = new ArrayList<>();
        allowed1.add("XYD");
        allowed1.add("YZE");
        allowed1.add("DEA");
        allowed1.add("FFF");

        Assert.assertTrue(leetcode756.pyramidTransition(bottom1, allowed1));
    }

    @Test
    public void test2() {
        Leetcode756 leetcode756 = new Leetcode756();

        String bottom = "XXYX";
        List<String> allowed = new ArrayList<>();
        allowed.add("XXX");
        allowed.add("XXY");
        allowed.add("XYX");
        allowed.add("XYY");
        allowed.add("YXZ");

        Assert.assertFalse(leetcode756.pyramidTransition(bottom, allowed));
    }
}
