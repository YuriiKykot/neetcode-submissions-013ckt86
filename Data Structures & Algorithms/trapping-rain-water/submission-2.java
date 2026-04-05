class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int left = 0;
        int right = 0;
        int amount = 0;

        while (i < j) {
            if(height[i] < height[j]){
                if(height[i] >= left) left = height[i];
                amount += left -  height[i];
                i++;
            }else{
                if(height[j] >= right) right = height[j];
                amount += right -  height[j];
                j--;
            }
        }
        return amount;
    }
}
