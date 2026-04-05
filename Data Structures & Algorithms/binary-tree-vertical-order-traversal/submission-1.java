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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();

        int minCol = 0, maxCol = 0;

        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();

        q.add(new Pair<>(root,0));

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Pair<TreeNode,Integer> p = q.remove();

                TreeNode cur = p.getKey();
                int col = p.getValue();

                map.computeIfAbsent(col, x -> new ArrayList<>()).add(cur.val);

                minCol = Math.min(minCol,col);
                maxCol = Math.max(maxCol,col);

                if(cur.left != null) q.add(new Pair<>(cur.left, col - 1));
                if(cur.right != null) q.add(new Pair<>(cur.right, col + 1));
            }
        }

        for(int i = minCol; i <= maxCol; i++){
            res.add(map.get(i));
        }

        return res;
    }
}