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
    int maxD ;
    public int diameterOfBinaryTree(TreeNode root) {
        //want the max sum of length of left and right trees
        maxD = 0;
        dfs(root);
        return maxD;

        
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return -1;

        //get height of subtrees, sum, math.max with current
        int leftHeight = dfs(root.left) + 1;
        int rightHeight = dfs(root.right) + 1;

        // int height = Math.max(dfs(root.left), dfs(root.right)) + 1;
      
        // // maxD = Math.max(sum, maxD);
        maxD = Math.max(maxD, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight);
        

    }
}
