class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length - 1;
        int goal = len;
        for(int i = len; i >= 0; i--){
            if(nums[i] + i >= goal) goal = i;
        }
        return goal == 0 ? true : false;
    }
}
