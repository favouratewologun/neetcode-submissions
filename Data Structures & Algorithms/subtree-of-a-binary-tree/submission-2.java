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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        //create linked list of both in order traversal,

        Queue<TreeNode> rootQ = new LinkedList<>();
        rootQ.offer(root);

        TreeNode newRoot;

        while (!rootQ.isEmpty()) {
            newRoot = rootQ.poll();
            if (newRoot == null)
                continue;
            boolean same = isSameTree(newRoot, subRoot);
            if (same)
                return true;
            rootQ.offer(newRoot.left);
            rootQ.offer(newRoot.right);
        }    

        return false;    

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();

        queueP.offer(p);
        queueQ.offer(q);

        while (!queueP.isEmpty()) {
            TreeNode holdP = queueP.poll();
            TreeNode holdQ = queueQ.poll();

            // if (holdP != null)
            //     System.out.println("hold p " + holdP.val);
            // else  
            //     System.out.println("hold p null");
            
            // if (holdQ != null)
            //     System.out.println("hold Q " + holdQ.val);
            // else {
            //     System.out.println("hold q null");
            // }

            // System.out.println();

            if (holdP == null && holdQ == null)
                continue;
            if (holdP == null || holdQ == null)
                return false;
            else {
                if (holdP.val != holdQ.val)
                    return false;
                queueP.offer(holdP.left);
                queueP.offer(holdP.right);
                queueQ.offer(holdQ.left);
                queueQ.offer(holdQ.right);
            }
        }

        return queueQ.isEmpty();
    }
}
