class Solution {
    public int mySqrt(int x) {
        int l = 1; int r = x;

        while(l <= r){
            int m = l + (r - l) / 2;

            long sqr = (long)m * m;

            if(sqr < x){
                l = m + 1;
            }else if(sqr > x){
                r = m - 1;
            }else{
                return m;
            }
        }

        return r;
    }
}