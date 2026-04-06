class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(1,n,k,res,subset);
        return res;
    }

    public void dfs(int i, int n, int k, List<List<Integer>> res, List<Integer> subset){
        if(subset.size() >= k){
            res.add(new ArrayList<>(subset));
            return;
        }
        if(i > n) return;

        subset.add(i);
        dfs(i+1,n,k,res,subset);
        subset.remove(subset.size() - 1);
        dfs(i+1,n,k,res,subset);
    }
}