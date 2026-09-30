/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root.left, Integer.MIN_VALUE, root.val) && check(root.right, root.val, Integer.MAX_VALUE);
    }

    public boolean check(TreeNode node, int min, int max) {
        if (node == null)
            return true;

        if (node.val <= min || node.val >= max) //not within bounds
            return false;

        return check(node.left, min, node.val) && check(node.right, node.val, max);

    }
}
