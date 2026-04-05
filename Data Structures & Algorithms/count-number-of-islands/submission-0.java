class Solution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
    
        int[][] visited = new int[ROWS][COLS];
        int islands = 0;

        for(int i = 0; i < ROWS; i++){
            for(int y = 0; y < COLS; y++){
                if(visited[i][y] != 0) continue;
                if(grid[i][y] == '1') {
                    islands += 1;
                    dfs(grid,i,y,visited,COLS,ROWS);
                }
            }
        }

        return islands;
    }

    void dfs(char[][] grid, int r, int c, int[][] visited, int COLS, int ROWS){
        if (Math.min(r, c) < 0 || r == ROWS || c == COLS ||
            visited[r][c] != 0 || grid[r][c] == '0' ) {
            return;
        }
        visited[r][c] = 1;

        dfs(grid, r + 1, c, visited, COLS, ROWS);
        dfs(grid, r - 1, c, visited, COLS, ROWS);
        dfs(grid, r, c + 1, visited, COLS, ROWS);
        dfs(grid, r, c - 1, visited, COLS, ROWS);
    }
}
