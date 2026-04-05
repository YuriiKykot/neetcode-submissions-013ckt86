class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        
        while(k > 1){
            System.out.println(cur + " num");
            System.out.println(k + " k");

            long left = cur;
            long right = cur;
            int size = 0;

            while(left <= n){
                size += Math.min(right, n) - left + 1;

                left *= 10;
                right = right * 10 + 9;
            }

            System.out.println(size + " size");

            if(size >= k){
                k -= 1;
                cur *= 10;
            }else if(size < k){
                k -= size;
                cur += 1;
            }
        }

        return cur;
    }
}