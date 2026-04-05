class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> list = new PriorityQueue<>();

        for(int n : nums){
            list.add(n);
            if(list.size() > k) list.poll();
        }

        return list.poll();
    }
}
