import airbnb.Leetcode773;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lijiang on 2019/3/26.
 */

public class Leetcode773Test {

  @Test
  public void test1() {
    Leetcode773 leetcode773 = new Leetcode773();

    int[][]board = {{4,1,2},{5,0,3}};

    Assert.assertEquals(leetcode773.slidingPuzzle(board),5);
  }
}
