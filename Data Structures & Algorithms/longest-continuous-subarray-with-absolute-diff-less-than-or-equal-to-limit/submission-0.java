class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> inc = new ArrayDeque<>();
        Deque<Integer> dec = new ArrayDeque<>();

        int res = 1;
        int l = 0;

        for(int i = 0; i < nums.length; i++){
            while(!inc.isEmpty() && nums[inc.peekLast()] >= nums[i]){
                inc.pollLast();
            }
            inc.addLast(i);
            while(!dec.isEmpty() && nums[dec.peekLast()] <= nums[i]){
                dec.pollLast();
            }
            dec.addLast(i);

            while(nums[dec.peekFirst()] - nums[inc.peekFirst()] > limit){
                l++;
                if(inc.peekFirst() < l) inc.pollFirst();
                if(dec.peekFirst() < l) dec.pollFirst();
            }

            res = Math.max(res, i - l + 1);
        }

        return res;
    }
}