class Solution {
    public void solve(char[][] board) {
        int r = board.length, c = board[0].length;
        boolean[][] visited = new boolean[r][c];

        for(int i = 0; i < r; i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board,visited);
            }
            if(board[i][c-1] == 'O'){
                dfs(i,c-1,board,visited);
            }
        }

        for(int i = 0; i < c; i++){
            if(board[0][i] == 'O'){
                dfs(0,i,board,visited);
            }
            if(board[r-1][i] == 'O'){
                dfs(r-1,i,board,visited);
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int x, int y, char[][] board, boolean[][] visited){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length 
            || visited[x][y] || board[x][y] != 'O') return;

        visited[x][y] = true;
        board[x][y] = '#';

        dfs(x + 1, y, board, visited);
        dfs(x - 1, y, board, visited);
        dfs(x, y + 1, board, visited);
        dfs(x, y - 1, board, visited);
    }
}
