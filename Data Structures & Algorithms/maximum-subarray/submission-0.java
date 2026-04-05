class Solution {
    public int maxSubArray(int[] nums) {
        int min = 0, max = 0;
        int res = nums[0];

        for(int i = nums.length - 1; i >= 0; i--){
            int tmp = max;
            max = Math.max(Math.max(max+nums[i],min+nums[i]),nums[i]);
            min = Math.min(Math.min(tmp+nums[i],min+nums[i]),nums[i]);
            res = Math.max(res,max);
        }

        return res;
    }
}
