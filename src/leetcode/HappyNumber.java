package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number (https://leetcode.com/problems/happy-number/)
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<String> cache = new HashSet<>();

        String s = Integer.toString(n);

        while (!cache.contains(s)) {
            cache.add(s);
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += Math.pow(s.charAt(i) - '0', 2);
            }
            s = Integer.toString(sum);

            if (s.equals("1")) {
                return true;
            }
        }

        return false;
    }
}
