class Solution {
    public int[] getConcatenation(int[] nums) {
        int y = nums.length;
        int x = 0;
        int stop = y;
        int[] ans = new int[nums.length * 2];
        
        while(x < stop){
            ans[x] = nums[x];
            ans[y] = nums[x];
            x++;
            y++;
        }

        return ans;
    }
}