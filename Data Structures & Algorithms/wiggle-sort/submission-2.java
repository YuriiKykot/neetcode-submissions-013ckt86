class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            boolean even = i % 2 == 0 ? false : true;

            if(even && nums[i - 1] > nums[i]){
                changeNums(i,i-1,nums);
            }else if(!even && nums[i - 1] < nums[i]){
                changeNums(i,i-1,nums);
            }
        }
    }

    public void changeNums(int i, int j, int[] nums){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
