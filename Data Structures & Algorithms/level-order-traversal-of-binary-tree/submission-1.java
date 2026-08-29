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
        List<List<Integer>> level = new ArrayList<>();

        if (root == null)
            return level;

        Queue<TreeNode> orders = new LinkedList<TreeNode>();
        orders.offer(root);

        while (!orders.isEmpty()) {
            int currQueueSize = orders.size();
            List<Integer> thisLevel = new ArrayList<>();
            for (int i = 0; i < currQueueSize; i++) {
                TreeNode currNode = orders.poll();
                if (currNode != null) {
                    thisLevel.add(currNode.val);
                    if (currNode.left != null)
                        orders.offer(currNode.left);
                    if (currNode.right != null)
                        orders.offer(currNode.right);
                }
                
            } 
            level.add(thisLevel);                  

        }

        return level;
        
    }
}
