class Solution {
    Boolean[][] m;

    public boolean isMatch(String s, String p) {
        m = new Boolean[s.length()+1][p.length()+1];
        return dfs(0,0,s,p);
    }

    public boolean dfs(int i, int j, String s, String p){
        int iL = s.length(), jL = p.length();
        if(j == jL) return i == iL;
        if(m[i][j] != null) return m[i][j];
        
        boolean res = false;
        boolean match = i < iL && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');  
        if(j + 1 < jL && p.charAt(j + 1) == '*'){
            res = dfs(i, j + 2, s, p) || (match && dfs(i + 1, j, s, p));
            m[i][j] = res;
            return res;
        } 

        if(match){
            res = dfs(i + 1, j + 1, s, p);
            m[i][j] = res;
            return res;
        } 

        m[i][j] = res;
        return res;
    }
}
