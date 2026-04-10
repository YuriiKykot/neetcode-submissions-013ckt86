class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0; int r = 0;
        int res = Integer.MAX_VALUE;
        for (int weight : weights) {
            l = Math.max(l, weight);
            r += weight;
        }
        while(l <= r){
            int m = (l + r) / 2;
            int d = 0;
            int cap = 0;

            for (int weight : weights) {
                if(cap + weight > m){
                    d++;
                    cap = 0;
                }
                cap += weight;
            }   
            d++;

            if(d > days){
                l = m + 1;
            }else{
                res = Math.min(res,m);
                r = m - 1;
            }
        }
        return res;
    }
}