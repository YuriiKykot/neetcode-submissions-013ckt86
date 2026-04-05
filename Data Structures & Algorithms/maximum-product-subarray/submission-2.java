class Solution {
    public int maxProduct(int[] nums) {
        int min = 1, max = 1;
        int curMax = nums[0];

        for(int i = 0; i < nums.length; i++){
            int tmp = min;
            min = Math.min(Math.min(nums[i]*min,nums[i]*max),nums[i]);
            max = Math.max(Math.max(nums[i]*tmp,nums[i]*max),nums[i]);
            curMax = Math.max(curMax,max);
        }

        return curMax;
    }
}

