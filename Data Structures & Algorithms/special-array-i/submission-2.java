class Solution {
    public boolean isArraySpecial(int[] nums) {
        int prev = nums[0] % 2;

        for(int i = 1; i < nums.length; i++){
            int num = nums[i] % 2;
            if(prev == num) return false;
            prev = num;
        }

        return true;
    }
}