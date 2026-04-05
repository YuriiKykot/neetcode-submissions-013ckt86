class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        k = k - 1;
        int steps = nums.length - k;
        int[] res = new int[steps];

        for(int i = k; i < nums.length; i++){
            int max = nums[i - k];
            for(int j = i - k + 1; j <= i; j++){
                max = Math.max(max,nums[j]);
            }
            res[i - k] = max;
        }

        return res; 
    }
}
