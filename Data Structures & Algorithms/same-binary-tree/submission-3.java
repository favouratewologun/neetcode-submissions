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
        Queue<TreeNode> pQ = new ArrayDeque<>();
        Queue<TreeNode> qQ = new ArrayDeque<>();

        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        
        

        return p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);

        // pQ.offer(p);
        // qQ.offer(q);

        // TreeNode pNode;
        // TreeNode qNode;

        // //look up null pointer...missing it somewhere..shouldnt continue deal with that?

        // while (!pQ.isEmpty() && !qQ.isEmpty()) {
        //     pNode = pQ.poll();
        //     qNode = qQ.poll();

        //     if (pNode == null && qNode == null)
        //         continue;
        //     else if (pNode == null || qNode == null)
        //         return false;

        //     if (pNode.val != qNode.val)
        //         return false;
            
        //     if (pNode.right != null)
        //         pQ.offer(pNode.right);
        //     if (pNode.left != null)
        //         pQ.offer(pNode.left);
        //     if (qNode.right != null)
        //         qQ.offer(qNode.right);
        //     if (qNode.left != null)
        //         qQ.offer(qNode.left);

        // }

        // return pQ.isEmpty() && qQ.isEmpty();
        
    }
}
