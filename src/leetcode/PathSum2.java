package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II (https://leetcode.com/problems/path-sum-ii/submissions/)
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root, targetSum, ans, new ArrayList<>());
        return ans;
    }

    private void pathSum(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            pathSum(root.left, targetSum - root.val, ans, path);
            pathSum(root.right, targetSum - root.val, ans, path);
        }

        path.remove(path.size() - 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
