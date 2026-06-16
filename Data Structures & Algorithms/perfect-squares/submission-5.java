class Solution {
    static Map<Integer, Integer> memo = new HashMap<>();

    public int numSquares(int n) {
        return dfs(n);
    }

    private int dfs(int target){
        if(target == 0) return 0;
        if(memo.containsKey(target)) return memo.get(target);

        int res = target;
        for(int i = (int)Math.sqrt(target); i >= 1; i--){
            res = Math.min(res, 1 + dfs(target - i * i));
        }

        memo.put(target,res);
        return res;
    }
}