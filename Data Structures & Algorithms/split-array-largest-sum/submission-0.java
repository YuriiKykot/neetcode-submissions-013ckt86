class Solution {
    int[][] dp;

    public int splitArray(int[] nums, int k) {
        dp = new int[nums.length+1][k+1];

        return dfs(0, k, nums);
    }

    int dfs(int i, int k, int[] nums){
        if(i == nums.length){
            return k == 0 ? 0 : Integer.MAX_VALUE;
        }
        if(k == 0){
            return Integer.MAX_VALUE;
        }
        if(dp[i][k] != 0){
            return dp[i][k];
        }

        int res = Integer.MAX_VALUE;
        int curSum = 0;
        for(int j = i; j <= nums.length - k; j++){
            curSum += nums[j];
            res = Math.min(res, Math.max(curSum, dfs(j + 1, k - 1, nums)));
        }

        return dp[i][k] = res;
    }
}