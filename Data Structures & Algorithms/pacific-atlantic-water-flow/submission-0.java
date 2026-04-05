class Solution {
    int ROWS, COLS;
    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for(int i = 0; i < ROWS; i++){
            dfs(i,0,pac,heights);
            dfs(i,COLS-1,atl,heights);
        }

        for(int i = 0; i < COLS; i++){
            dfs(0,i,pac,heights);
            dfs(ROWS-1,i,atl,heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    public void dfs(int r, int c, boolean[][] o, int[][] h){
        o[r][c] = true;
        for(int[] d : directions){
            int nr = r + d[0], nc = c + d[1];
            if(nr < ROWS && nc < COLS && nr >= 0 && nc >= 0 
                && !o[nr][nc] && h[nr][nc] >= h[r][c]){
                    dfs(nr,nc,o,h);
                }
        }

    }
}
