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

        // TreeNode temp = root.left;
        // root.left = invertTree(root.right);
        // root.right = invertTree(temp);

        // return root;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr  = root;
        TreeNode holdRoot = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
           

            curr = stack.pop();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            curr = curr.left;

        }

        return holdRoot;
        
    }
}
