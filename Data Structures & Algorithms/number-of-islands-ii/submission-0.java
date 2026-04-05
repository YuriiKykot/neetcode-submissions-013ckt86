class Solution {
    int[][] sea;
    boolean[][] visited;
    int R, C;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();

        sea = new int[m][n];
        R = m; C = n;

        for(int g = 0; g < positions.length; g++){
            int count = 0;

            int x = positions[g][0];
            int y = positions[g][1];

            sea[x][y] = 1;
            visited = new boolean[m][n];

            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(sea[i][j] == 1 && visited[i][j] == false){
                        count++;
                        dfs(i,j,visited,sea);
                    }
                }
            }

            res.add(count);
        }

        return res;
    }

    public void dfs(int x, int y, boolean[][] v, int[][] s){
        if(x < 0 || y < 0 || x >= R || y >= C ||
            v[x][y] == true || s[x][y] == 0) return;

        v[x][y] = true;
        dfs(x,y+1,v,s);
        dfs(x,y-1,v,s);
        dfs(x+1,y,v,s);
        dfs(x-1,y,v,s);    
    }
}
