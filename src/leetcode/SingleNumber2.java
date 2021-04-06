package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. Single Number II (https://leetcode.com/problems/single-number-ii/)
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) == 3) {
                map.remove(num);
            }
        }

        return map.keySet().iterator().next();
    }
}
