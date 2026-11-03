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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxHeight = new int[1];

        calcHeight(root, maxHeight);
        return maxHeight[0];
        
    }

    public int calcHeight(TreeNode root, int[] maxHeight) {
        if (root == null)
            return -1;

        int leftHeight = calcHeight(root.left, maxHeight) + 1;
        int rightHeight = calcHeight(root.right, maxHeight) + 1;

        maxHeight[0] = Math.max(maxHeight[0], leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight);
    }
}
