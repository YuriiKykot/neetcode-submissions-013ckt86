class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res,new boolean[candidates.length],target,new ArrayList<>(), candidates, 0);
        return res;
    }

    public void dfs(List<List<Integer>> list, boolean[] pick, int target, List<Integer> res, int[] candidates, int idx){
        if(target == 0){
            list.add(new ArrayList<>(res));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = idx; i < candidates.length; i++){
            if(!pick[i]){
                if(i > idx && candidates[i] == candidates[i - 1]) continue;

                res.add(candidates[i]);
                pick[i] = true;

                dfs(list,pick,target - candidates[i],res,candidates,i + 1);

                res.remove(res.size() - 1);
                pick[i] = false;
            }
        }
    }
}
