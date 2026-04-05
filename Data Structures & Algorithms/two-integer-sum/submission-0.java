class Solution {
    public int[] twoSum(int[] nums, int target) {
        int x = 0;
        int y = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int key = target - nums[i];
            if(map.containsKey(key)){
                x = map.get(key);
                y = i;
                break;
            }
            map.put(nums[i],i);
        }
        int[] a = {x,y};
        return a;
    }
}
