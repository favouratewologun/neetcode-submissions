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
    public int goodNodes(TreeNode root) {
        //int maxVal//
        return check(root, -200);
        
    }

    private int check(TreeNode root, int maxVal) {
        if (root == null)
            return 0;

        if (root.val < maxVal) {
            return check(root.right, maxVal) + check(root.left, maxVal);
        } else {
            return 1 + check(root.right, root.val) + check(root.left, root.val);
        }
    }
}
