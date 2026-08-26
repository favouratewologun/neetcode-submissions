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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQ = new LinkedList<>();
        Queue<TreeNode> qQ = new LinkedList<>();
        
        pQ.offer(p);
        qQ.offer(q);

        while (!pQ.isEmpty()) {
            TreeNode pNode = pQ.poll();
            TreeNode qNode = qQ.poll();
            if (pNode == null && qNode == null) { 
                continue; //null node
            } else if (pNode != null && qNode != null) {
                if (pNode.val != qNode.val) // make sure same vall
                    return false;
                pQ.offer(pNode.left);
                pQ.offer(pNode.right);
                qQ.offer(qNode.left);
                qQ.offer(qNode.right);
            } else {
                return false; //nodes are off
            }

        }

        return true;

        

        //make sure qq is also empty
        

        



        
    }
}
