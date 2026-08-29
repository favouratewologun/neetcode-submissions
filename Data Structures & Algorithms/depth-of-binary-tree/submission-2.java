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
        int maxD = 0;

        Deque<Object> stack = new ArrayDeque<>();

        if (root == null)
            return 0;

        stack.push(root);
        stack.push(1);

        while (!stack.isEmpty()) {
            int currD = (int) stack.pop();
            TreeNode currNode = (TreeNode) stack.pop();
            maxD = Math.max(maxD, currD);  

            if (currNode.left != null) {
                stack.push(currNode.left);
                stack.push(currD + 1);
                maxD = Math.max(maxD, currD + 1);
            }
            if (currNode.right != null) {
                stack.push(currNode.right);
                stack.push(currD + 1);
                maxD = Math.max(maxD, currD + 1);
            }
        }

        return maxD;
        
    }
}
