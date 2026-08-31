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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //find the path that leads to both, add to queue, look for the last node that contains both

        Queue<TreeNode> queue = new ArrayDeque<>();

        TreeNode pNode = root;
        queue.offer(root);

        while (pNode != p) { //is this even valid
            if (pNode.val < p.val) {
                pNode = pNode.right;
            } else { //curr node > val
                pNode = pNode.left;
            }

            queue.offer(pNode);

        }

        TreeNode qNode = root;

        TreeNode currLowest = queue.poll();
        //create queue from original.
        //as go through second, as we see, poll and hold on

        while (qNode != q) { 
            if (qNode.val < q.val) {
                qNode = qNode.right;
            } else { //curr node > val
                qNode = qNode.left;
            }

            if (qNode == queue.peek()) {
                currLowest = queue.poll();
            } else { //gone off
                return currLowest;
            }

        }

        return currLowest;

        //iterate through both lists,
        
    }
}
