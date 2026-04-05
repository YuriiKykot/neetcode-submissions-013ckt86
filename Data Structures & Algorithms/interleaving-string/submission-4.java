class Solution {
    Boolean[][] n;
    public boolean isInterleave(String s1, String s2, String s3) {
        n = new Boolean[s1.length()+1][s2.length()+1];
        return dfs(0,0,0, s1,s2,s3);
    }

    public boolean dfs(int x, int y, int z, String s1, String s2, String s3){
        if(z == s3.length()){
            return x == s1.length() && y == s2.length();
        }

        if(n[x][y] != null) return n[x][y];

        boolean res = false;

        if(x < s1.length() && s1.charAt(x) == s3.charAt(z)){
            res = dfs(x+1,y,z+1,s1,s2,s3);
        }

        if(y < s2.length() && s2.charAt(y) == s3.charAt(z)){
            res = dfs(x,y+1,z+1,s1,s2,s3);
        }
        return n[x][y] = res;
    }
}
