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
        List<String> res = new ArrayList<>();
        dfsSer(root,res);
        return String.join(",",res);
    }

    private void dfsSer(TreeNode n, List<String> res){
        if(n == null){
            res.add("N");
            return;
        }

        res.add(String.valueOf(n.val));
        dfsSer(n.left,res);
        dfsSer(n.right,res);
    }

    public static Integer i;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res = data.split(",");
        i = 0;
        return dfsDes(res);
    }

    private TreeNode dfsDes(String[] l){
        if(l[i].equals("N")){
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(l[i]));
        i++;
        node.left = dfsDes(l);
        node.right = dfsDes(l);

        return node;
    }
}
