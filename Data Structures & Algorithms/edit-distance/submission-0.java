class Solution {
    Integer[][] a;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        a = new Integer[m+1][n+1];

        return dfs(0, 0, word1, word2, m, n);
    }

    private int dfs(int i, int j, String word1, String word2, int m, int n){
        if(i >= m) return n - j;
        if(j >= n) return m - i;
        if(a[i][j] != null) return a[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            return dfs(i+1,j+1,word1,word2,m,n);
        }else{
            int res = Math.min(
                dfs(i+1,j,word1,word2,m,n),
                dfs(i,j+1,word1,word2,m,n)
            );

            res = Math.min(
                res,
                dfs(i+1,j+1,word1,word2,m,n)
            );

            a[i][j] = res + 1;
            return a[i][j];
        }
    }
}
