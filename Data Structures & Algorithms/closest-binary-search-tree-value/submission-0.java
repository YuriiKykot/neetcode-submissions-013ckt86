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
    public int closestValue(TreeNode root, double target) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);

        double prev = Double.MAX_VALUE;
        int resNumber = 0;

        for(int i : list){
            double diff = Math.abs(i - target);
            
            if(diff < prev){
                resNumber = i;
                prev = diff;
            }
        }

        return resNumber;
    }

    public void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
