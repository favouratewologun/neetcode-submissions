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
    public int goodNodes(TreeNode root) {
        //obs a dfs

        //keep track of smallest val in tree
        //as you go, increase good nodes if still good,

        int good = 0;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayDeque<Integer> minStack = new ArrayDeque<>();

        TreeNode curr = root;
        int maxSeen = root.val;

        //need to account for if switching directions of a tree, can ignore min seen from old branch

        while (curr != null || !stack.isEmpty()) {
            //good if on the way to that node, nothing is bigger than it
            while (curr != null) {
                if (curr.val >= maxSeen) {
                    good++;
                }

                maxSeen = Math.max(curr.val, maxSeen);
                minStack.push(maxSeen);

                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            maxSeen = minStack.pop();
            curr = curr.right;
            
        } 

        return good;
        
    }
}
