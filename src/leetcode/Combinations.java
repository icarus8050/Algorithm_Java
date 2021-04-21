package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations (https://leetcode.com/problems/combinations/)
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combine(ans, new ArrayList<>(), 1, n, k);
        return ans;
    }

    private void combine(List<List<Integer>> ans, List<Integer> comb, int s, int n, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        for (int i = s; i <= n; i++) {
            comb.add(i);
            combine(ans, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}
