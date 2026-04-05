class Solution {
    public int rob(int[] nums) {
        return 
        Math.max(
            nums[0],
            Math.max(
                robe(Arrays.copyOfRange(nums,1,nums.length)),
                robe(Arrays.copyOfRange(nums,0,nums.length-1))
            )
        );
    }

    public int robe(int[] nums){
        int rob1 = 0, rob2 = 0;

        for(int n : nums){
            int max = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = max;
        }
        return rob2;
    }
}
