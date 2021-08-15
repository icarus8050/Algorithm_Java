package leetcode;

/**
 * 111. Minimum Depth of Binary Tree (https://leetcode.com/problems/minimum-depth-of-binary-tree/)
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;
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
