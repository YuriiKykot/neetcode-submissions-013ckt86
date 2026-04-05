class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (Integer m : map.keySet()) {
            int[] arr = new int[2];
            arr[0] = m;
            arr[1] = map.get(m); 
            pq.offer(arr); 
        }

        int[] arr = new int[k];

        for(int i = 0; i < k; i++){
            int[] tmp = pq.poll();
            arr[i] = tmp[0];
        }

        return arr;
    }
}
