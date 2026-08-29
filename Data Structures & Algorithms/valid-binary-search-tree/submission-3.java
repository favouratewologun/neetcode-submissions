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
        // can do an in order travesal, if nums are all less, than good
        ArrayList<Integer> inOrder = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null)
            return true;

        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (curr != null)
                inOrder.add(curr.val);
            
            curr = curr.right;         
        }

        System.out.println(inOrder);
        
        int prev = inOrder.get(0);
        for (int i = 1; i < inOrder.size(); i++) {
            int currV = inOrder.get(i);
            if (prev >= currV)
                return false;
            prev = currV;
        }

        return true;
      
        
    }
}
