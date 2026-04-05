class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int currentNumber = nums[0];
        int b = 0;
        for(int i = 0; i < nums.length; i++){
            if (currentNumber < nums[i]) {
                currentNumber = nums[i];
                b++;
                nums[b] = currentNumber;
            }
        }

        return b + 1;
    }
}