package airbnb;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

/**
 * I have a wish list of cities that I want to visit to, my friends also have city wish lists that they want to visit to.
 * If one of my friends share more than 50% (over his city count in his wish list), he is my buddy.
 * <p>
 * Given a list of city wish list, output buddy list sorting by similarity.
 */
public class TravelBuddy {

    public List<List<Integer>> findBuddy(List<List<Integer>> cities) {
        if (cities == null || cities.size() < 2) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();

        return res;
    }
}
