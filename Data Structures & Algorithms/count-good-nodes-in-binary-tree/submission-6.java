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
        return good(root, 0, -200);
    }

    public int good(TreeNode root, int numGood, int maxVal) {
        if (root == null)
            return 0;

        if (maxVal <= root.val)
            return 1 + good(root.left, numGood, root.val) + good(root.right, numGood, root.val);

        else
            return good(root.left, numGood, maxVal) + good(root.right, numGood, maxVal);
    }
}
