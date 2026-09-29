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
    boolean isBalanced;

    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        getHeight(root);

        
        return isBalanced;
        
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            // isBalanced = true;
            return -1;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        // if (Math.abs(leftHeight - rightHeight) <= 1)
        //     isBalanced = true;
        // else
        if (Math.abs(leftHeight - rightHeight) > 1)
            isBalanced = false;

        return Math.max(leftHeight, rightHeight) + 1;

    }
}
