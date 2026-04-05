class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(0,1);

        int count = 0;
        int prefix = 0;

        for(int num : nums){
            prefix += num;
            count += m.getOrDefault(prefix-k,0);
            m.put(prefix, m.getOrDefault(prefix,0) + 1);
        }

        return count;
    }
}