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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Stack<TreeNode> q = new Stack<>();
        Stack<TreeNode> q2 = new Stack<>();

        q.add(root);

        List<List<Integer>> res = new ArrayList<>();

        boolean useStack = false;

        while(!q.isEmpty() || !q2.isEmpty()){
            int size = useStack ? q2.size() : q.size();
            List<Integer> currentLayer = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (useStack) {
                    TreeNode current = q2.pop();
                    currentLayer.add(current.val);

                    if (current.right != null) q.add(current.right);
                    if (current.left != null) q.add(current.left);
                } else {
                    TreeNode current = q.pop();
                    currentLayer.add(current.val);

                    if (current.left != null) q2.add(current.left);
                    if (current.right != null) q2.add(current.right);
                }
            }

            useStack = !useStack;

            res.add(currentLayer);
        }

        return res;
    }
}