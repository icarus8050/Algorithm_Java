package leetcode;

/**
 * 112. Path Sum (https://leetcode.com/problems/path-sum/)
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == sum) {
                return true;
            }
            return false;
        }

        if (root.left != null && hasPathSum(root.left, targetSum, sum)) {
            return true;
        }

        if (root.right != null && hasPathSum(root.right, targetSum, sum)) {
            return true;
        }

        return false;
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
