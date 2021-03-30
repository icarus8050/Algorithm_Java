package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 136. Single Number (https://leetcode.com/problems/single-number/)
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        return set.stream().mapToInt(Integer::intValue)
                .findFirst().getAsInt();
    }
}
