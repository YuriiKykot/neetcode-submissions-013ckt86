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
    public boolean isValidBST(TreeNode root) {
        return recursion(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean recursion(TreeNode root, long left, long right){
        if(root == null) return true;

        if(!(left < root.val && root.val < right)) return false;

        return recursion(root.left,left,root.val) && recursion(root.right, root.val, right);
    }
}
