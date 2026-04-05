class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n - 1 < edges.length) return false;

        Set<Integer> set = new HashSet<>();

        if(!dfs(0,-1,set,edges)){
            return false;
        }

        return set.size() == n;
    }

    public boolean dfs(int node, int parent, Set<Integer> set, int[][] edges){
        System.out.println(node + " " + parent);
        if(set.contains(node)) return false;

        set.add(node);
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

            if(!dfs(n[1],node,set,edges)){
                return false;
            }
        }
        return true;
    }
}
