class Solution {
    Map<Integer,Integer> map;
    List<Integer> res;

    public List<Integer> majorityElement(int[] nums) {
        map = new HashMap<>();
        res = new ArrayList<>();


        for(int n : nums){
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > nums.length / 3){
                res.add(entry.getKey());
            }
        }

        return res;
    }
}