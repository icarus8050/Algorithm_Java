package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 75. Sort Colors (https://leetcode.com/problems/sort-colors/)
 */
public class SortColors {
    public void sortColors(int[] nums) {
        List<Integer> zeros = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        List<Integer> twos = new ArrayList<>();

        for (int num : nums) {
            if (num == 0) {
                zeros.add(num);
            } else if (num == 1) {
                ones.add(num);
            } else {
                twos.add(num);
            }
        }

        zeros.addAll(ones);
        zeros.addAll(twos);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = zeros.get(i);
        }
    }
}
