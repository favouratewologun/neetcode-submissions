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

public class Codec {
    private int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //create a sring. add val of node and left?
        //do as bfs

        ArrayList<String> res = new ArrayList<>();
        dfsS(root, res);
        StringBuilder sRes = new StringBuilder();
        for (String s : res) {
            sRes.append(s + ",");
    
        }

        String resultS = sRes.toString();
        return resultS.substring(0, resultS.length() - 1); //drop last comma

    }

    public static void dfsS(TreeNode root, ArrayList<String> res) {
        if (root == null) {
            res.add("N");
            return;

        }
        
        res.add(Integer.toString(root.val));
        dfsS(root.left, res);
        dfsS(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        index = 0;

        return dfsD(arr);
        
    }

    public TreeNode dfsD(String[] arr) {
        if (arr[index].equals("N")) {
            index++;
            return null;
        }
            

        TreeNode n = new TreeNode(Integer.parseInt(arr[index]));
        index++;
        n.left = dfsD(arr);
        n.right = dfsD(arr);

        return n;

    }


}
