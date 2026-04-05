class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        
        for(int i = nums.length - 1; i >= 0; i--){
            if(dp[i] == 0) dp[i] = 1;
            for(int j = i; j < nums.length; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(dp[i],max);
        }

        return max;
    }
}
