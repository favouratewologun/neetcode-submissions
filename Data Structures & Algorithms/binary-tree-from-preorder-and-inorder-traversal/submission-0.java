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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preInd = new int[]{0};
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }

        return build(preInd, index, preorder, 0, inorder.length - 1);
        
    }

    private TreeNode build(int[] preInd, HashMap<Integer, Integer> index, int[] preorder, int l, int r) {
        if (l > r) //done with this end
            return null;

        int root_val = preorder[preInd[0]];
        preInd[0]++;

        TreeNode root = new TreeNode(root_val);

        int mid = index.get(root_val);

        root.left = build(preInd, index, preorder, l, mid - 1);
        root.right = build(preInd, index, preorder, mid + 1, r);

        return root;
        
    }

}
