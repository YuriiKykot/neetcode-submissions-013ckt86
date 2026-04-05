class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> res = new ArrayList<>();
        bfs(res,new ArrayList<>(), nums,0);
        return res;
    }

    public void bfs(List<List<Integer>> res, List<Integer> cur, int[] nums, int k){
        res.add(new ArrayList<>(cur));
        for(int i = k; i < nums.length; i++){
            if(i > k && nums[i-1] == nums[i]){
                continue;
            }
            cur.add(nums[i]);
            bfs(res,cur,nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
