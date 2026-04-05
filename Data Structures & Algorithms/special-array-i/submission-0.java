class Solution {
    public boolean isArraySpecial(int[] nums) {
        int prev = nums[0] % 2;

        for(int i = 1; i < nums.length; i++){
            if(prev == nums[i] % 2) return false;
            prev = nums[i] % 2;
        }

        return true;
    }
}