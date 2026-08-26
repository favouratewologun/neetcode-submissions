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
        
        // TreeNode currLeft = root.left;
        // TreeNode currRight = root.right;

        // root.right = invertTree(currLeft);
        // root.left = invertTree(currRight);

        // return root;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode l = node.left;
            TreeNode r = node.right;

            node.left = r;
            node.right = l;

            if (r != null)
                q.offer(r);
            if (l != null)
                q.offer(l);

        }

        return root;

        
    }
}
