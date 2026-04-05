class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int m = l + (r - l) / 2;
            if(nums[m] == target) return true;
            
            if(nums[m] > target){
                r = m -1;
            }else{
                l = m + 1;
            }
        }

        return false;
    }
}