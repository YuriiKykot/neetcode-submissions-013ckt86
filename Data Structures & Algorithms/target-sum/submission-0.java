class Solution {
    Map<String, Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();
        return dfs(0, nums, target, 0);
    }

    public int dfs(int i, int[] nums, int target, int total){
        String key = i + "," + total;

        if(map.containsKey(key)){
            return map.get(key);
        }

        if(i == nums.length){
            return total == target ? 1 : 0;
        }

        int sum = dfs(i + 1, nums, target, total - nums[i]) +
            dfs(i + 1, nums, target, total + nums[i]);

        map.put(key,sum);

        return sum;    
    }
}
