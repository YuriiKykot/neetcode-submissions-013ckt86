class Solution {
    public int smallestCommonElement(int[][] mat) {
        for(int i = 0; i < mat[0].length; i++){
            if(binarySearch(mat[0][i], mat)) return mat[0][i];
        }
        return -1;
    }

    public boolean binarySearch(int k, int[][] mat){
        int count = 0;

        for(int arr = 1; arr < mat.length; arr++){
            int l = 0;
            int r = mat[arr].length - 1;

            while(l <= r){
                int m = l + (r - l) / 2;

                if(k == mat[arr][m]){
                    count++;
                    break;
                }

                if(k > mat[arr][m]){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
        }

        return count < mat.length - 1 ? false : true;
    }
}
