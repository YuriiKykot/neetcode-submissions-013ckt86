class Solution {
    public int arrangeCoins(int n) {
        int l = 1; int r = n; int res = 0;

        while(l <= r){
            int m = l + (r - l) / 2;
            long coins = (long) m * (m + 1) / 2;

            if(coins > n){
                r = m - 1;
            }else{
                l = m + 1;
                res = Math.max(res,m);
            }
        }

        return res;
    }
}