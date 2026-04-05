class Solution {
    public int numSubseq(int[] nums, int target) {
        int result = 0;

        int MOD = 1_000_000_007;
        Arrays.sort(nums);

        int[] pow = new int[nums.length];
        pow[0] = 1;
        for(int i = 1; i < nums.length; i++){
            pow[i] = (pow[i-1] * 2) % MOD;
        }

        for(int i = 0; i < nums.length; i++){
            int l = i;
            int r = nums.length - 1;

            int s = target - nums[i];
            int res = i - 1;

            while(l <= r){
                int m = l + (r - l) / 2;

                if(nums[m] <= s){
                    res = m;
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }

            if(res >= i){
                 result = (result + pow[res - i]) % MOD;
            }
        }

        return result;
    }
}