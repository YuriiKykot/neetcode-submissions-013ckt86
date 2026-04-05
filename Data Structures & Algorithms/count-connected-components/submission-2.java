class Solution {
    public int countComponents(int n, int[][] edges) {
        Set<Integer> set = new HashSet<>();

        int res = 0;
        for(int i = 0; i < n; i++){;
            if(set.contains(i)){ 
                continue;
            }

            res+=1;
            dfs(i,-1,set,edges);
        }

        return res;
    }

    public void dfs(int node, int parent, Set<Integer> visited, int[][] edges){
        if(visited.contains(node)) return;

        visited.add(node);

        for(int i = 0; i < edges.length; i++){
            int[] n = edges[i];

            if(n[0] == node || n[1] == node){
                if(n[1] == node){
                    int buf = n[0];
                    n[0] = n[1];
                    n[1] = buf;
                }
            }else{
                continue;
            }

            if(n[1] == parent) continue;

            dfs(n[1],node,visited,edges);
        }
    }
}
