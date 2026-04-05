class Solution {
    Integer[][] m;

    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;

        m = new Integer[s.length()+1][t.length()+1];

        return dfs(0,0,s,t);
    }

    public int dfs(int x, int y, String s, String t){
        if(y == t.length()) return 1;
        if(x == s.length()) return 0;
        if(m[x][y] != null) return m[x][y];

        int res = dfs(x + 1, y, s, t);
        if(s.charAt(x) == t.charAt(y)){
            res += dfs(x + 1, y + 1, s, t);
        }
        m[x][y] = res;
        return res;
    }
}
