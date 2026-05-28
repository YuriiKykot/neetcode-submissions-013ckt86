class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for(int i = 0; i < nums.length; i++){
            System.out.println(res + " " + nums[i]);
            if(res == nums[i]){
                res++;
            }
        }
        return res;
    }
}