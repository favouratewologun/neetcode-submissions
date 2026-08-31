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
        //find the path that leads to both, add to array, look for the last node that contains both

        // ArrayList<TreeNode> pPath = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        TreeNode pNode = root;
        // pPath.add(pNode);
        queue.offer(root);

        while (pNode != p) { //is this even valid
            if (pNode.val < p.val) {
                pNode = pNode.right;
            } else { //curr node > val
                pNode = pNode.left;
            }

            // pPath.add(pNode);
            queue.offer(pNode);

        }

        // ArrayList<TreeNode> qPath = new ArrayList<>();

        TreeNode qNode = root;
        // qPath.add(qNode);

        TreeNode currLowest = queue.poll();
        //create queue from original.
        //as go through second, as we see, poll and hold on

        while (qNode != q) { //is this even valid
            if (qNode.val < q.val) {
                qNode = qNode.right;
            } else { //curr node > val
                qNode = qNode.left;
            }

            // qPath.add(qNode);
            if (!queue.isEmpty() && qNode == queue.peek()) {
                currLowest = queue.poll();
            }

        }

        return currLowest;

        //iterate through both lists,
        
    }
}
