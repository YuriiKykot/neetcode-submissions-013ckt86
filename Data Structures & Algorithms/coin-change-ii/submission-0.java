class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] memo = new int[coins.length + 1][amount + 1];
        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i],-1);
        }

        return dfs(amount, 0, coins,memo);
    }

    private int dfs(int a, int i, int[] coins, int[][] memo){
        if(a == 0) return 1;
        if(i >= coins.length ) return 0;
        if(memo[i][a] != -1) return memo[i][a];

        int res = 0;
        if(a >= coins[i]){
            res = dfs(a, i + 1, coins, memo);
            res += dfs(a - coins[i], i, coins, memo);
        }
        memo[i][a] = res;
        return res;
    }
}
