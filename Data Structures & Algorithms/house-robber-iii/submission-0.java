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
    private Map<TreeNode, Integer> cache;

    public int rob(TreeNode root) {
        cache = new HashMap<>();
        cache.put(null,0);
        return dfs(root);
    }

    public int dfs(TreeNode n){
        if(cache.containsKey(n)){
            return cache.get(n);
        }

        int notRob = n.val;
        
        if(n.left != null){
            notRob += dfs(n.left.left) + dfs(n.left.right);
        }
        if(n.right != null){
            notRob += dfs(n.right.left) + dfs(n.right.right);
        }

        int rob = dfs(n.right) + dfs(n.left);

        int res = Math.max(rob,notRob);
        cache.put(n,res);

        return res;
    }
}