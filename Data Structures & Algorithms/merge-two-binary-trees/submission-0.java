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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;

        Queue<TreeNode[]> q = new LinkedList<>();
        TreeNode head = new TreeNode();

        q.add(new TreeNode[]{root1, root2, head});

        while(!q.isEmpty()){
            TreeNode[] triple = q.remove();
            TreeNode r1 = triple[0];
            TreeNode r2 = triple[1];
            TreeNode cur = triple[2];

            if (r1 != null) cur.val += r1.val;
            if (r2 != null) cur.val += r2.val;

            TreeNode l1 = (r1 != null) ? r1.left  : null;
            TreeNode l2 = (r2 != null) ? r2.left  : null;
            TreeNode rr1 = (r1 != null) ? r1.right : null;
            TreeNode rr2 = (r2 != null) ? r2.right : null;

            if(l1 != null || l2 != null){
                cur.left = new TreeNode();
                q.add(new TreeNode[]{l1,l2,cur.left});
            }

            if(rr1 != null || rr2 != null){
                cur.right = new TreeNode();
                q.add(new TreeNode[]{rr1,rr2,cur.right});
            }
        }

        return head;
    }
}