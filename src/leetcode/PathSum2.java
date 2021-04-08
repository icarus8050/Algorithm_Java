package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II (https://leetcode.com/problems/path-sum-ii/submissions/)
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        pathSum(root, targetSum, ans, new ArrayList<>());
        return ans;
    }

    private void pathSum(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> path) {
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                List<Integer> tmp = new ArrayList<>(path);
                tmp.add(root.val);
                ans.add(tmp);
            }
            return;
        }

        if (root.left != null) {
            path.add(root.val);
            pathSum(root.left, targetSum - root.val, ans, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.val);
            pathSum(root.right, targetSum - root.val, ans, path);
            path.remove(path.size() - 1);
        }
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
