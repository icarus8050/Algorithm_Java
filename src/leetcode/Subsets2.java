package leetcode;

import java.util.*;

/**
 * 90. Subsets II (https://leetcode.com/problems/subsets-ii/)
 */
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        ans.add(new ArrayList<>());
        subsetsWithDup(ans, new ArrayList<>(), 0, nums);
        return new ArrayList<>(ans);
    }

    public void subsetsWithDup(Set<List<Integer>> ans, List<Integer> list, int idx, int[] nums) {
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            List<Integer> temp = new ArrayList<>(list);
            temp.sort(Comparator.comparingInt(a -> a));
            ans.add(temp);
            subsetsWithDup(ans, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets2 subsets2 = new Subsets2();
        int[] arg = {4,4,1,4};
        subsets2.subsetsWithDup(arg);
    }
}
