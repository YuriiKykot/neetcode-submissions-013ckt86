class Node{
    int val;
    HashSet<Node> n;

    public Node(int val){
        this.val = val;
        n = new HashSet<>();
    }
}

class Solution {
    

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        Map<Integer, Node> map = new HashMap<>();

        for(int i = 0; i < prerequisites.length; i++){
            for(int j = 0; j < prerequisites[0].length; j += 2){
                Node x = null;
                Node y = null;

                int v1 = prerequisites[i][j];
                int v2 = prerequisites[i][j+1];

                if(map.containsKey(v1)){
                    x = map.get(v1);
                }else{
                    x = new Node(v1);
                    map.put(v1,x);
                }

                if(map.containsKey(v2)){
                    y = map.get(v2);
                }else{
                    y = new Node(v2);
                    map.put(v2,y);
                }

                x.n.add(y);
            }
        }

        for(Node n : map.values()){
            if(!dfs(new HashSet<Node>(), n)) return false;
        }

        return true;
    }

    public boolean dfs(HashSet<Node> visited, Node node){
        if(visited.contains(node)){
            return false;
        } 

        visited.add(node);
        
        for (Node x : node.n) {
            if(!dfs(visited,x)){
                return false;
            }
            visited.remove(x);
        }

        return true;
    }
}
