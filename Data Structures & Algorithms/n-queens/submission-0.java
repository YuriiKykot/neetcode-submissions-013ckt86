class Solution {
    Set<Integer> col;
    Set<Integer> posDiag;
    Set<Integer> negDiag;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        col = new HashSet<>();
        posDiag = new HashSet<>();
        negDiag = new HashSet<>();
        res = new ArrayList<>();

        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row,'.');
        }

        dfs(0,n,board);

        return res;
    }

    private void dfs(int r, int n, char[][] board){

        if(r == n){
            List<String> copy = new ArrayList<>();
            for(char[] row : board){
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for(int c = 0; c < n; c++){
            if(col.contains(c) || posDiag.contains(r+c) 
                || negDiag.contains(r-c)) continue;
            
            col.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            board[r][c] = 'Q';

            dfs(r+1,n,board);

            col.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            board[r][c] = '.';
        }
    }
}
