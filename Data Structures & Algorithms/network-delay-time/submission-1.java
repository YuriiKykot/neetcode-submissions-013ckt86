class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            edges.computeIfAbsent(time[0],
            key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                                       Comparator.comparingInt(a -> a[0]));

        Set<Integer> visited = new HashSet<>();
        minHeap.offer(new int[]{0,k});
        int t = 0;
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int time = cur[0];
            int node = cur[1];
            if(visited.contains(node)){
                continue;
            }
            visited.add(node);
            t = time;

            if(edges.containsKey(node)){
                for(int[] next : edges.get(node)){
                    int node2 = next[0];
                    int time2 = next[1];
                    if(!visited.contains(node2)){
                        minHeap.offer(new int[]{time2+time,node2});
                    }
                }
            }
        }

        return visited.size() == n ? t : -1;
    }
}
