class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int cur = 0;
        int res = 0;

        for(int i = 0; i < k; i++){
            cur += arr[i];
        }

        double avg = cur / k;
        if(avg >= threshold) res++;

        for(int i = k; i < arr.length; i++){
            cur -= arr[i-k];
            cur += arr[i];

            avg = cur / k;
            
            if(avg >= threshold) res++;
        }

        return res;
    }
}