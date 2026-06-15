class Solution {
    boolean[] col, posDiag, negDiag;
    int res;

    public int totalNQueens(int n) {
        col = new boolean[n];
        posDiag = new boolean[2 * n];
        negDiag = new boolean[2 * n];
        res = 0;

        backtrack(0,n);
        return res;
    }

    private void backtrack(int r, int n){
        if(r == n){
            res++;
            return;
        }
        for(int c = 0; c < n; c++){
            if(col[c] || posDiag[r + c] || negDiag[r - c + n]){
                continue;
            }
            col[c] = true;
            posDiag[r + c] = true;
            negDiag[r - c + n] = true;

            backtrack(r + 1, n);

            col[c] = false;
            posDiag[r + c] = false;
            negDiag[r - c + n] = false;
        }
    }
}