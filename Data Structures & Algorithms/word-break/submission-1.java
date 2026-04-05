class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int slen = s.length();
        boolean[] dp = new boolean[slen + 1];
        dp[slen] = true;

        for(int i = slen - 1; i >= 0; i--){
            for(String w : wordDict){
                if(slen - i >=  w.length() && s.substring(i, i + w.length()).equals(w)){
                    dp[i] = dp[i + w.length()];
                }
                if(dp[i]){
                    break;
                }
            }
        }

        return dp[0];
    }
}
