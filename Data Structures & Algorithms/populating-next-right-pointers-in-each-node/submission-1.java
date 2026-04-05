/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Node x = q.remove();

                 if (i < size - 1) {
                    x.next = q.peek();
                } else {
                    x.next = null;
                }

                if(x != null && x.left != null) q.add(x.left);
                if(x != null && x.right != null) q.add(x.right);
            }
        }

        return root;
    }
}