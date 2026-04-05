class Solution {
    public int countPaths(int[][] grid) {
        if(grid == null || grid.length < 1) return 0;
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] visited = new int[ROWS][COLS];
        return dfs(visited,0,0,grid,ROWS,COLS);
    }

    int dfs(int[][] visited, int i, int y, int[][] grid, int ROWS, int COLS){
        if (Math.min(i, y) < 0 || i == ROWS || y == COLS ||
            visited[i][y] != 0 || grid[i][y] == 1 ) return 0;
        if(i == ROWS - 1 && y == COLS - 1) return 1;

        visited[i][y] = 1;

        int count = 0;

        count += dfs(visited, i + 1, y, grid, ROWS, COLS);
        count += dfs(visited, i - 1, y, grid, ROWS, COLS);
        count += dfs(visited, i, y + 1, grid, ROWS, COLS);
        count += dfs(visited, i, y - 1, grid, ROWS, COLS);

        visited[i][y] = 0;
        return count;
    }
}
