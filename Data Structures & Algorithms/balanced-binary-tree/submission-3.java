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
    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        boolean[] balanced = new boolean[1];
        balanced[0] = true;

        calcHeight(root, balanced);

        return balanced[0];
    
    }

    public int calcHeight(TreeNode root, boolean[] balanced) {
        if (root == null)
            return -1;

        int heightL = calcHeight(root.left, balanced);
        int heightR = calcHeight(root.right, balanced);

        if (Math.abs(heightL - heightR) > 1)
            balanced[0] = false;
        
        return Math.max(heightL, heightR) + 1;
    }
}
