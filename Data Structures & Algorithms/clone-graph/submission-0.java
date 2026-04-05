/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node start = new Node(node.val);
        dfs(node,start,new HashSet<Node>(), new HashMap<Node,Node>());
        return start;
    }

    public void dfs(Node org, Node copy, HashSet<Node> visit, Map<Node, Node> map){
        if (visit.contains(org)) return;

        map.put(org,copy);
        visit.add(org);

        for (Node n : org.neighbors) {
            Node node = null;
            
            if(map.containsKey(n)) node = map.get(n);
            else node = new Node(n.val);

            copy.neighbors.add(node);
            dfs(n, node, visit,map);
        }

        return;
    }
}