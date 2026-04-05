class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int max = 0;

        for(int i = 0; i < ROWS; i++){
            for(int y = 0; y < COLS; y++){
                if(grid[i][y] == 0) continue;
                else max = Math.max(max,dfs(i,y,grid,ROWS,COLS));
            }
        }

        return max;
    }

    public int dfs(int r, int c, int[][] grid, int ROWS, int COLS){
        if(ROWS == r || COLS == c || Math.min(r,c) < 0 || grid[r][c] == 0){
            return 0;
        }

        System.out.println("1");

        grid[r][c] = 0;

        return 1 + dfs(r + 1, c, grid, ROWS, COLS) 
        + dfs(r - 1, c, grid, ROWS, COLS) 
        + dfs(r, c + 1, grid, ROWS, COLS) 
        + dfs(r, c - 1, grid, ROWS, COLS);
    }
}
