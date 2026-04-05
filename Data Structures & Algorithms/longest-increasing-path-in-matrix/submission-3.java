class Solution {
    Integer[][] map;

    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        map = new Integer[ROWS+1][COLS+1];
        int res = 0;
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                res = Math.max(res,dfs(matrix,r,c,Integer.MIN_VALUE));
            }
        }
        return res;
    }

    private int dfs(int[][] m, int r, int c, int p){
        int ROWS = m.length, COLS = m[0].length;
        if(r < 0 || r >= ROWS || c < 0 || c >= COLS || m[r][c] <= p){
            return 0;
        }
        if(map[r][c] != null) return map[r][c];

        int res = 1 + Math.max(dfs(m, r + 1, c, m[r][c]),
            Math.max(dfs(m,r-1,c,m[r][c]), 
            Math.max(dfs(m,r,c-1,m[r][c]),dfs(m,r,c+1,m[r][c]))));

        map[r][c] = res;
        return res;
    }
}
