class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0, min = 0, sum = 0;

        for(int i = 0; i < piles.length; i++){
            if(piles[i] > r) r = piles[i];
        }

        while(l <= r){
            int m = l + (r - l) / 2;
            int buf = 0;

            for(int i = 0; i < piles.length; i++){
                buf += (piles[i] + m - 1) / m;
            }

            System.out.println(buf + " " + m);

            if(buf > h) l = m + 1;
            else if(buf <= h) r = m - 1;

            if(buf >= sum && buf <= h){
                min = m;
                sum = buf;
            }
        }

        return min;
    }
}
