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
    public List<Integer> rightSideView(TreeNode root) {
        int depth = 0;
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        addNodes(res, root, 0);

        return res;
        
    }

    public void addNodes(List<Integer> res, TreeNode root, int depth) {
        if (root == null)
            return;

        if (res.size() == depth) {
            res.add(root.val);
        }

        addNodes(res, root.right, depth + 1);
        addNodes(res, root.left, depth + 1);
    }
}
