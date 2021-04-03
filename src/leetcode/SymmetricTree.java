package leetcode;

/**
 * 101. Symmetric Tree (https://leetcode.com/problems/symmetric-tree/)
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }

        if (!isSymmetric(left.left, right.right)) {
            return false;
        }

        if (!isSymmetric(left.right, right.left)) {
            return false;
        }

        return true;
    }

    static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(2);
        TreeNode four = new TreeNode();
        TreeNode five = new TreeNode(3);
        TreeNode six = new TreeNode();
        TreeNode seven = new TreeNode(3);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        System.out.println(new SymmetricTree().isSymmetric(one));
    }
}
