class Solution {
    static int r;
    static int c;
    static Set<List<Integer>> set;
    static char[] chars;

    public boolean exist(char[][] board, String word) {
        this.r = board.length;
        this.c = board[0].length;
        this.set = new HashSet<>();
        this.chars = word.toCharArray();

        for(int i = 0; i < r; i++){
            for(int y = 0; y < c; y++){
                if(board[i][y] == chars[0]){
                    set.clear();
                    boolean res = rec(new int[]{i,y},0,board);
                    if(res) return true;
                }
            }
        }

        return false;
    }

    public boolean rec(int[] cord, int i, char[][] board) {
        int a = cord[0];
        int b = cord[1];

        if(a < 0 || a >= r || b < 0 || b >= c) return false;

        if(board[a][b] != chars[i]) return false;
        
        System.out.println(board[a][b]);

        List<Integer> l = Arrays.asList(a, b);
        if(set.contains(l)) return false;
        set.add(l);

        if(i == chars.length - 1) return true;

        boolean res = rec(new int[]{a+1,b}, i+1, board) ||
                  rec(new int[]{a-1,b}, i+1, board) ||
                  rec(new int[]{a,b-1}, i+1, board) ||
                  rec(new int[]{a,b+1}, i+1, board);

        set.remove(l);
        return res;
    }
}
