class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int x = 0;
        int y = numbers.length - 1;
        int[] res = new int[2];

        while(x < y){
            int sum = numbers[x] + numbers[y];
            if(sum > target) y--;
            if(sum < target) x++;
            if(sum == target){
                res[0] = ++x;
                res[1] = ++y;
                break;
            } 
        }

        return res;
    }
}
