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

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);


        while (!stack.isEmpty()) {

            TreeNode currNode = stack.pop();

            if (currNode == null)
                return null;

            TreeNode temp = currNode.left;
            currNode.left = currNode.right;
            currNode.right = temp;

            if (currNode.left != null) {
                stack.push(currNode.left);
            }
            
            if (currNode.right != null) {
                stack.push(currNode.right);
            }
            
        }

        return root;


        
    }
}
