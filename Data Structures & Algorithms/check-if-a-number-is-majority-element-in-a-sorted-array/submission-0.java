class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int l = 0; int r = nums.length - 1;

        int count = 0;

        while(l <= r){
            int m = l + (r - l) / 2;

            if(nums[m] == target){
                int i = m;
                while(i < nums.length && nums[i] == target){
                    count++;
                    i++;
                }
                i = m - 1;
                while(i >= 0 && nums[i] == target){
                    count++;
                    i--;
                }
                break;
            }

            if(nums[m] > target){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }

        return nums.length / 2 < count;
    }
}
