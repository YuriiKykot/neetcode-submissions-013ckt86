class Solution {
    int[] prices;    
    Integer[][] dp;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        dp = new Integer[prices.length][2];

        return dfs(0,false);
    }

    public int dfs(int i, boolean sell){
        if(i >= prices.length) return 0;
        
        if(sell){
            if(dp[i][0] != null) return dp[i][0];
        }else{
            if(dp[i][1] != null) return dp[i][1];
        }

        int res = dfs(i + 1, sell);
        if(sell){
            res = Math.max(res, prices[i] + dfs(i + 1, false));
        }else{
            res = Math.max(res, -prices[i] + dfs(i + 1, true));
        }

        if(sell){
            dp[i][0] = res;
        }else{
            dp[i][1] = res;
        }

        return res;
    }
}