class Solution {
    public boolean canPartition(int[] nums) {
        int size = nums.length;
        int sum = 0;

        for(int i = 0; i < size; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }

        return dfs(sum / 2, 0, nums);
    }

    public boolean dfs(int target,int i,int[] nums){
        if(i == nums.length) return target == 0;
        if(target < 0) return false;

        return dfs(target, i + 1, nums) || dfs(target - nums[i], i + 1, nums);    
    } 
}
