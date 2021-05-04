package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal (https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        zigzagLevelOrder(root, 0, ans);
        return ans;
    }

    private void zigzagLevelOrder(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }

        if (level % 2 == 0) {
            ans.get(level).add(root.val);
        } else {
            ans.get(level).add(0, root.val);
        }
        zigzagLevelOrder(root.left, level + 1, ans);
        zigzagLevelOrder(root.right, level + 1, ans);
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
