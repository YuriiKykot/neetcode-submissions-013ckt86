class Solution {
    private int[][] dp;

    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;

        for(int stone : stones){
            stoneSum += stone;
        }

        int target = (stoneSum + 1) / 2;

        dp = new int[stones.length][target + 1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        return dfs(0, 0, stones, stoneSum, target);
    }
    
    private int dfs(int i, int total, int[] stones, int stoneSum, int target){
            if(total >= target || i >= stones.length){
                return Math.abs(stoneSum - total * 2);
            }

            if(dp[i][total] != -1) return dp[i][total];

            int res = Math.min(
                dfs(i + 1, total, stones, stoneSum, target),
                dfs(i + 1, total + stones[i], stones, stoneSum, target)
            );

            dp[i][total] = res;

            return res;
        }
}