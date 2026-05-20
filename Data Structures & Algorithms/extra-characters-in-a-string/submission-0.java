class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> words = new HashSet<>(Arrays.asList(dictionary));
        
        Integer[] dp = new Integer[s.length() + 1];

        dp[s.length()] = 0;

        return dfs(0, s, words, dp);
    }

    public int dfs(int i, String s, Set<String> words, Integer[] dp){
        if(dp[i] != null) return dp[i];
        int res = 1 + dfs(i + 1, s, words, dp);
        for(int j = i; j < s.length(); j++){
            if(words.contains(s.substring(i, j + 1))){
                res = Math.min(res, dfs(j + 1, s, words, dp));
            }
        }
        dp[i] = res;
        return res;
    }
}