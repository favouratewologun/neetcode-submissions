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

        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> ints = new ArrayDeque<>();

        nodes.push(root);
        ints.push(1);

        int maxD = 0;

        while (!nodes.isEmpty()) {
            int d = ints.pop();
            maxD = Math.max(maxD, d);
            TreeNode node = nodes.pop();
            if (node.left != null) {
                nodes.push(node.left);
                ints.push(d + 1);
            }

            if (node.right != null) {
                nodes.push(node.right);
                ints.push(d + 1);
            }

        }

        return maxD;
        
        //return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        
    }
}
