class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i + 1; j < len; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                map.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{distance, j});
                map.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{distance, i});
            }
        }

        int res = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<int[]> minH = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minH.offer(new int[]{0, 0});
        while (visit.size() < len){
            int[] cur = minH.poll();
            int cost = cur[0];
            int i = cur[1];
            if (visit.contains(i)) {
                continue;
            }
            res += cost;
            visit.add(i);
            for(int[] nei : map.getOrDefault(i, Collections.emptyList())){
                int neiCost = nei[0];
                int neiIndex = nei[1];
                if (!visit.contains(neiIndex)) {
                    minH.offer(new int[]{neiCost, neiIndex});
                }
            }
        }
        return res;
    }
}
