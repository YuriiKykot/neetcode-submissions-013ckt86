class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    findMaxConsecutiveOnes(nums) {
        let res = 0;
        let cur = 0;

        for(let i = 0; i < nums.length; i++){
            if(nums[i] === 1){ 
                cur++;
            }else{
                res = Math.max(cur,res);
                cur = 0;
            }
        }

        res = Math.max(cur,res);

        return res;
    }
}
