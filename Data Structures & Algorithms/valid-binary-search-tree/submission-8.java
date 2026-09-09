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
    public boolean isValidBST(TreeNode root) {
        //create a queue of in order traversal...go through

        Queue<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            //make sure not null first?
            curr = stack.pop();
            queue.offer(curr);
            curr = curr.right;
        }

        int currNum = queue.poll().val;

        while (!queue.isEmpty()) {
            TreeNode nextNum = queue.poll();
            if (nextNum == null)
                return false;
            
            if (nextNum.val <= currNum)
                return false;
            currNum = nextNum.val;
        }

        return true;




        
    }
}
