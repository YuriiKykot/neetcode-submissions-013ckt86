class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Integer m : map.keySet()) {
            pq.offer(new int[]{map.get(m),m});
            if(pq.size() > k) pq.poll();
        }

        int[] arr = new int[k];
        for(int i = 0; i < k; i++){
            arr[i] = pq.poll()[1];
        }
        return arr;
    }
}
