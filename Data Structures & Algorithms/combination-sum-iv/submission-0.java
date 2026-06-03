class Solution {
    private Map<Integer,Integer> dp;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        dp = new HashMap();
        dp.put(0,1);
        return dfs(nums, target);
    }

    private int dfs(int nums[], int total){
        if(dp.containsKey(total)){
            return dp.get(total);
        }

        int res = 0;
        for(int num : nums){
            if(total < num){
                break;
            }  
            res += dfs(nums, total - num);
        }
        dp.put(total,res);
        return res;
    }
}