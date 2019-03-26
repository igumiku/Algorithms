package airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode756 {

    private Map<String, List<Character>> tree = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        buildResultTree(allowed);

        List<Character> initLevel = new ArrayList<>();

        for (int i = 0; i < bottom.length(); i++) {
            initLevel.add(bottom.charAt(i));
        }

        return backstack(0, initLevel, new ArrayList<>());
    }

    private boolean backstack(int index, List<Character> level, List<Character> nextLevel) {

        if (index == level.size() - 1) {

            if (index == 1) {
                return true;
            }

            index = 0;
            level = nextLevel;
            nextLevel = new ArrayList<>();
        }

        String sub = level.get(index) + "" + level.get(index + 1);

        if (!tree.containsKey(sub)) {
            return false;
        }

        for (Character c : tree.get(sub)) {
            nextLevel.add(c);
            if (backstack(index + 1, level, nextLevel)) {
                return true;
            }

            nextLevel.remove(c);
        }

        return false;

    }

    private void buildResultTree(List<String> allowed) {

        for (String a : allowed) {
            String sub = a.substring(0, 2);
            List<Character> subResult = tree.computeIfAbsent(sub, k -> new ArrayList<>());

            char c = a.charAt(2);
            subResult.add(c);
        }
    }
}
