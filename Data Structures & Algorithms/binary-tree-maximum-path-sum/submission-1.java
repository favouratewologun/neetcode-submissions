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
    public int maxPathSum(TreeNode root) {
        //2^n sol is to choose or not choose each item, choose left or right, continue

        HashSet<Integer> sums = new HashSet<>();
        int[] maxSum = new int[]{root.val};

        traverse(root, maxSum);

        return maxSum[0];

    }

    private int traverse(TreeNode root, int[] maxSum) {
        
        if (root == null)
            return 0;

        int leftSum = Math.max(traverse(root.left, maxSum), 0);
        int rightSum = Math.max(traverse(root.right, maxSum), 0);

        int selfMax = root.val + leftSum + rightSum;

        maxSum[0] = Math.max(selfMax, maxSum[0]);

        return Math.max(leftSum, rightSum) + root.val;        

    }

    
}
