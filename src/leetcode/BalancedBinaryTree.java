package leetcode;

/**
 * 110. Balanced Binary Tree (https://leetcode.com/problems/balanced-binary-tree/)
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getSubTreeHeight(root.left) - getSubTreeHeight(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int getSubTreeHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getSubTreeHeight(node.left), getSubTreeHeight(node.right)) + 1;
    }

    public class TreeNode {
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
