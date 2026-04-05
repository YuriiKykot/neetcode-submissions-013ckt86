class Solution {
    static int counter = 0;
    static int max = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        counter = 0;
        max = 0;

        for(int i = 0; i < ROWS; i++){
            for(int y = 0; y < COLS; y++){
                if(grid[i][y] == 0) continue;
                else dfs(i,y,grid,ROWS,COLS);

                if(counter > max) max = counter;
                counter = 0; 
            }
        }

        return max;
    }

    public void dfs(int r, int c, int[][] grid, int ROWS, int COLS){
        if(ROWS == r || COLS == c || Math.min(r,c) < 0 || grid[r][c] == 0){
            return;
        }

        System.out.println("1");

        grid[r][c] = 0;

        dfs(r + 1, c, grid, ROWS, COLS);
        dfs(r - 1, c, grid, ROWS, COLS);
        dfs(r, c + 1, grid, ROWS, COLS);
        dfs(r, c - 1, grid, ROWS, COLS);

        counter++;
    }
}
