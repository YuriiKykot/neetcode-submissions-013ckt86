class Solution {
    Integer[][] dp;

    public int minPathSum(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        dp = new Integer[ROWS][COLS];
        return dfs(0,0,grid);
    }

    public int dfs(int r, int c, int[][] grid){
        if(r == grid.length - 1 && c == grid[0].length - 1){
            return grid[r][c];
        }
        if(r == grid.length || c == grid[0].length){
            return Integer.MAX_VALUE;
        }  
        if(dp[r][c] != null){
            return dp[r][c];
        }

        dp[r][c] = grid[r][c] + Math.min(dfs(r + 1, c, grid),dfs(r,c+1,grid));
        return dp[r][c];
    }
}