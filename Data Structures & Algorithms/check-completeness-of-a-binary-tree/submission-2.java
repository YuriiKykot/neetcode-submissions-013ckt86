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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        boolean isLeaf = false;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode n = q.remove();
                int nChildrens = 0;

                if(isLeaf && (n.right != null || n.left != null)){
                    return false;
                }

                if(n.right != null && n.left == null){
                    return false;
                }

                if(n.right == null && n.left == null){
                    isLeaf = true;
                }

                if(n.left != null){
                    q.add(n.left);
                }
                if(n.right != null){
                    q.add(n.right);
                }
            }
        }

        return true;
    }
}