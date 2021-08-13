package leetcode;

/**
 * 108. Convert Sorted Array to Binary Search Tree (https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] t = {-10, -3, 0, 5, 9};
        sortedArrayToBST(t);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return bts(nums, 0, nums.length);
    }

    public static TreeNode bts(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        if (left < mid) treeNode.left = bts(nums, left, mid);
        if (right > mid + 1) treeNode.right = bts(nums, mid + 1, right);
        return treeNode;
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
