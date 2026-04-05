class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] p : prerequisites){
            map.computeIfAbsent(p[0],
                k -> new ArrayList<>()).add(p[1]);
        }

        List<Integer> output = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for(int i = 0; i < numCourses; i++){
            if(!dfs(map,output,visited,cycle,i)){
                return new int[]{};
            }
        }

        int[] res = new int[output.size()];
        for(int i = 0; i < output.size(); i++){
            res[i] = output.get(i);
        }

        return res;
    }

    public boolean dfs(Map<Integer, List<Integer>> map, List<Integer> out, Set<Integer> vis, Set<Integer> cycle, int i){
        if(cycle.contains(i)) return false;
        
        if(vis.contains(i)) return true;
        
        cycle.add(i);
        for(int j : map.getOrDefault(i, Collections.emptyList())){
            if(!dfs(map,out,vis,cycle,j)) return false;
        }
        cycle.remove(i);
        vis.add(i);
        out.add(i);
        return true;
    }
}
