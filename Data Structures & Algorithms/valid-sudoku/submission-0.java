class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rows = new HashMap<>();
        Map<Integer,Set<Character>> cols = new HashMap<>();
        Map<String,Set<Character>> squares = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int y = 0; y < 9; y++){
                if(board[i][y] == '.') continue;
                String keySquare = i/3 + "," + y/3;

                if(!rows.containsKey(i)) rows.put(i,new HashSet<>());
                if(!cols.containsKey(y)) cols.put(y,new HashSet<>());
                if(!squares.containsKey(keySquare)) squares.put(keySquare,new HashSet<>());

                if(rows.get(i).contains(board[i][y]) 
                || cols.get(y).contains(board[i][y]) 
                || squares.get(keySquare).contains(board[i][y])){
                    return false;
                }

                rows.get(i).add(board[i][y]);
                cols.get(y).add(board[i][y]);
                squares.get(keySquare).add(board[i][y]);
            }
        }

        return true;
    }
}
