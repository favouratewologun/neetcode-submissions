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
    //create is sametree, then check if sametree...cant do subtree bc doesnt work.
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //dfs, check if left or right or self if equal

        //check if equal, if so, check if subtrees are equal
        //if not, check if any of its subtrees are equal to the subroot

        if (root == null && subRoot == null)
            return true;
        
        if (root == null || subRoot == null)
            return false;

        //atp, both valid   
        boolean valid;

        if (root.val == subRoot.val)  {
            valid = isSameTree(root, subRoot); // vals are equal, check same tree
            if (valid)
                return valid;
            // else 
            //     return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        } //else //see is anything lower is a subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        //if the vals are equal but it doesnt work, need to redo, subtree again.

        //if the vals are euqal and both are subtrees, then good. if vals aren't equal, return check subtree

        //have to return false if root.val not auto equal? but that doesnt seem
       // return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
            

        

    }

    public boolean isSameTree(TreeNode root, TreeNode subroot) {
        if (root == null && subroot == null)
            return true;
        
        if (root == null || subroot == null)
            return false;

        return root.val == subroot.val && isSameTree(root.left, subroot.left) && isSameTree(root.right, subroot.right);

    }
}
