class NumMatrix {

    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        prefixSum = new int[ROWS + 1][COLS + 1];

        for(int i = 0; i < ROWS; i++){
            int prefix = 0;
            for(int j = 0; j < COLS; j++){
                prefix += matrix[i][j];
                int above = prefixSum[i][j+1];
                prefixSum[i+1][j+1] = prefix + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;

        int bottomRight = prefixSum[row2][col2];
        int above = prefixSum[row1-1][col2];
        int left = prefixSum[row2][col1-1];
        int topLeft = prefixSum[row1-1][col1-1];

        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */