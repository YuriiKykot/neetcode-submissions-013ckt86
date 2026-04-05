class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;

        for(int i = k - 1; i < nums.length; i++){
            diff = Math.min(diff, Math.abs(nums[i - k + 1] - nums[i]));
        }

        return diff;
    }
}