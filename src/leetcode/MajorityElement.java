package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element (https://leetcode.com/problems/majority-element/)
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int majority = -1;
        int count = -1;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            } else {
                map.compute(num, (key, value) -> {
                    value = value + 1;
                    return value;
                });
            }

            if (map.get(num) > count) {
                majority = num;
                count = map.get(num);
            }
        }

        return majority;
    }
}
