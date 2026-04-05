class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        return dfs(0, -1, adj, hasApple);
    }

    private int dfs(int cur, int parent, List<Integer>[] adj, List<Boolean> hasApple){
        int time = 0;
        for(int child : adj[cur]){
            if(child == parent) continue;
            int childTime = dfs(child,cur,adj,hasApple);
            if(childTime > 0 || hasApple.get(child)){
                time += 2 + childTime;
            }
        }
        return time;
    }
}