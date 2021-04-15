package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrder(root, 0, ans);
        return ans;
    }

    private void levelOrder(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        if (level == ans.size()) {
            ans.add(new ArrayList<>());
        }

        ans.get(level).add(root.val);
        levelOrder(root.left, level + 1, ans);
        levelOrder(root.right, level + 1, ans);
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

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        new BinaryTreeLevelOrderTraversal().levelOrder(node1);
    }
}
