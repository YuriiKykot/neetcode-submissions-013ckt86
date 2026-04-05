class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curentStream = 0;
        int streamBeforeZero = 0;
        int res = curentStream;

        for(int i = 0; i < nums.length; i++){
            res = Math.max(res,curentStream);
            if(nums[i] == 0){
                curentStream -= streamBeforeZero;
                curentStream++;
                streamBeforeZero = curentStream;
            }else{
                curentStream++;
            }
        }

        res = Math.max(res,curentStream);

        return res;
    }
}
