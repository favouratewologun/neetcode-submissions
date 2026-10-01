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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //do a dfs on it, add to arraylist
        if (root == null)
            return "";


        ArrayList<String> res = new ArrayList<>();
        serialHelper(root, res);
        StringBuilder sb = new StringBuilder();
        
        for (String r : res) {
            sb.append(r);
            sb.append(",");
        }

        String s = sb.toString();

        return s.substring(0, s.length() - 1); //to remove extra comma
        
    }

    private void serialHelper(TreeNode root, ArrayList<String> res) {
        if (root == null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(root.val));
        serialHelper(root.left, res);
        serialHelper(root.right, res);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;

        String ndata[] = data.split(",");
        int[] i = new int[]{0};

        return traverse(ndata, i);
        
    }

    private TreeNode traverse(String[] data, int[] i) {
        if (i[0] == data.length)
            return null;

        if (data[i[0]].equals("N")) {
             i[0]++;
            return null;
        }
           

        TreeNode node = new TreeNode(Integer.parseInt(data[i[0]]));
        i[0]++;
        node.left = traverse(data, i);
        node.right = traverse(data, i);

        return node;
        
    }


}
