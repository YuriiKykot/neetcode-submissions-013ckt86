class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0, max = 0;

        for(int i : nums){
            map.put(i, map.getOrDefault(i,0) + 1);
            if(map.get(i) > max){
                res = i;
                max = map.get(i);
            }
        }
        
        return res;
    }
}