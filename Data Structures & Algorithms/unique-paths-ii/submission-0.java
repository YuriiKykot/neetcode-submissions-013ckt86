class Solution {
    public int uniquePathsWithObstacles(int[][] g) {
        int m = g.length;
        int n = g[0].length;

        int[] prevRow = new int[n];
        for(int i = m - 1; i >= 0; i--){
            int[] curRow = new int[n];

            if(g[i][n-1] != 1)
                curRow[n-1] = 1;
            else if(i > 0)
                g[i-1][n-1] = 1;

            for(int j = n - 2; j >= 0; j--){
                if(g[i][j] != 1)
                    curRow[j] = curRow[j+1] + prevRow[j];
            }
            
            prevRow = curRow;
        }

        return prevRow[0];
    }
}