class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length * matrix[0].length == 1){
            return matrix[0][0] == target;
        }

        int L = 0;
        int R = (matrix.length * matrix[0].length) - 1;
        int d = matrix[0].length;

        while (R >= L){
            int mid = (R+L)/2;

            if(target > matrix[mid/d][mid%d]){
                L = mid + 1;
            }else if(target < matrix[mid/d][mid%d]){
                R = mid - 1;
            }else{
                return true;
            }
        }

        return false;
    }
}
