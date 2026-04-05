class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i = 0; i <= n; i++){
            int count = 0;
            int tmp = i;
            while(tmp > 0){
                if((tmp & 1) == 1){
                    count++;
                }
                tmp = tmp >> 1;
            }
            arr[i] = count;
        }
        return arr;
    }
}
