class Solution {
    public void sortColors(int[] nums) {
        int[] range = new int[3];
        int k = nums.length;

        for(int i = 0; i < k; i++){
            int val = nums[i];
            int newVal = range[val] + 1;
            range[val] = newVal;
        }

        int x = 0;
        for(int i = 0; i < range.length; i++){
            for(int j = 0; j < range[i]; j++){
                nums[x] = i;
                x++;
            }
        }
    }
}