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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode realRoot = root;

        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                TreeNode hold = root.left;
                root.left = root.right;
                root.right = hold;
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }

        return realRoot;

        // TreeNode hold = invertTree(root.left);
        // root.left = invertTree(root.right);
        // root.right = hold;

        // return root;


        
    }
}
