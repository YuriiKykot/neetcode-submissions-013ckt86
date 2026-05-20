class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k != 0) return false;

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];
 
        return dfs(0, nums.length - 1, k, sum / k, used, nums);
    }

    private boolean dfs(int currSum, int i, int left, int target, boolean[] used, int[] nums){
        if(left == 0) return true;

        if(currSum == target){
            return dfs(0, nums.length - 1, left - 1, target, used, nums);
        }

        for(int j = i; j >= 0; j--){
            if (used[j]) continue;
            if (currSum + nums[j] > target) continue;

            used[j] = true;

            if(dfs(currSum + nums[j], j - 1, left, target, used, nums)) return true;

            used[j] = false;

            if (currSum == 0) break;
        }

        return false;
    }
}