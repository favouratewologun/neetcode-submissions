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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null)
                    queue.offer(currNode.left);
                if (currNode.right != null)
                    queue.offer(currNode.right);
                currList.add(currNode.val);
                
            }
            res.add(new ArrayList<>(currList));

        }
        
        return res;
    }
}
