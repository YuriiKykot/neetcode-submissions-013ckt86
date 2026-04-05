class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int n : stones) maxHeap.add(n);

        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if(x > y){
                maxHeap.offer(x - y);
            }
        }

        return maxHeap.size() >= 1 ? maxHeap.poll() : 0;
    }
}
