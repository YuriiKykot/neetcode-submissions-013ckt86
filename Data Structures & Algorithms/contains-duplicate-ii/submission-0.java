class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0;

        for(int rigth = 0; rigth < nums.length; rigth++){
            if(rigth - left > k){
                set.remove(nums[left]);
                left++;
            }
            if(set.contains(nums[rigth])){
                return true;
            }
            set.add(nums[rigth]);
        }

        return false;
    }
}