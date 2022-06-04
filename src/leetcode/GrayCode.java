package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code (https://leetcode.com/problems/gray-code/)
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }
}
