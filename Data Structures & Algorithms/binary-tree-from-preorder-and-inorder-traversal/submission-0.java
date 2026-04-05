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
    public TreeNode buildTree(int[] p, int i[]){
        if(p == null || i == null) return null;

        List<Integer> preorder = Arrays.stream(p).boxed().toList();
        List<Integer> inorder  = Arrays.stream(i).boxed().toList();

        return build(preorder,inorder);
    }

    public TreeNode build(List<Integer> p, List<Integer> i){
        if(p.isEmpty() || i.isEmpty()) return null;

        Integer start = p.get(0);
        TreeNode root = new TreeNode(start);
        Integer mid = i.indexOf(start);
        
        root.left = build(p.subList(1, mid+1), i.subList(0, mid));
        root.right = build(p.subList(mid+1, p.size()), i.subList(mid+1, i.size()));

        return root;
    }
}
