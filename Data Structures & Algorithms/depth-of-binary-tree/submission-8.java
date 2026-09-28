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
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> iStack = new ArrayDeque<>();
        // stack.push(root);
        stack.push(root);
        iStack.push(1);
        int maxD = 0;
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            int v = iStack.pop();

            maxD = Math.max(v, maxD);

            if (curr.left != null) {
                stack.push(curr.left);
                iStack.push(v + 1);
            }

            if (curr.right != null) {
                stack.push(curr.right);
                iStack.push(v + 1);
            }
            
        }

        return maxD;
    }
}
