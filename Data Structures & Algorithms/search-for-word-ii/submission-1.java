
public class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean end = false;

    public TrieNode() {
        children = new HashMap<>();
    }

    public void insert(String word) {
        TrieNode curr = this;
        for(char c : word.toCharArray()){
            curr.children.putIfAbsent(c,new TrieNode());
            curr = curr.children.get(c);
        }
        curr.end = true;
    }
}

class Solution {
    private Set<String> res;
    private boolean[][] visit;
    private int ROWS;
    private int COLS;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for(String s : words){
            root.insert(s);
        }

        ROWS = board.length; 
        COLS = board[0].length;
        res = new HashSet<>();
        visit = new boolean[ROWS][COLS];

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                dfs(board,i,j,root,"");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] b, int r, int c, TrieNode n, String w){
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || visit[r][c] || !n.children.containsKey(b[r][c])) return;

        visit[r][c] = true;
        n = n.children.get(b[r][c]);
        w += b[r][c];
        if(n.end){
            res.add(w);
        }

        dfs(b, r + 1, c, n, w);
        dfs(b, r - 1, c, n, w);
        dfs(b, r, c + 1, n, w);
        dfs(b, r, c - 1, n, w);

        visit[r][c] = false;
    }
}
