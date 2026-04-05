class Solution {
    public int maxArea(int[] heights) {
        int x = 0;
        int y = heights.length - 1;
        int max = 0;

        while(x < y){
            int amount = (y - x) * Math.min(heights[x],heights[y]);
            max = Math.max(max,amount);

            if(heights[x] > heights[y]) {
                y--;
            }else{
                x++;
            }
        }

        return max;
    }
}
