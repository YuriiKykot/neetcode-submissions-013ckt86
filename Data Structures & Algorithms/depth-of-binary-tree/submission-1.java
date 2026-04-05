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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return recursion(root, 0);
    }

    public int recursion(TreeNode root, int d){
        if(root == null) return 0;
        
        int l = 1;
        int r = 1;
        l += recursion(root.left,d);
        r += recursion(root.right,d);
        d = Math.max(l,r);

        return d;
    }
}
