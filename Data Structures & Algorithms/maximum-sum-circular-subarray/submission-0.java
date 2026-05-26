class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMin = 0;
        int curMax = 0;
        int globalMin = nums[0];
        int globalMax = nums[0];
        int total = 0;

        for(int num : nums){
            curMin = Math.min(curMin + num, num);
            globalMin = Math.min(globalMin,curMin);

            curMax = Math.max(curMax + num, num);
            globalMax = Math.max(globalMax,curMax);

            total += num;
        }

        if(globalMax < 0) return globalMax;

        return Math.max(globalMax, total - globalMin);
    }
}