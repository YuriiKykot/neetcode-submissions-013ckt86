class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pick = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        PriorityQueue<int[]> drop = new PriorityQueue<>((x, y) -> x[2] - y[2]);

        for (int[] trip : trips) {
            pick.offer(trip);
        }

        int curr = 0;
        while (!pick.isEmpty()) {
            int[] next = pick.poll();

            while (!drop.isEmpty() && drop.peek()[2] <= next[1]) {
                curr -= drop.poll()[0];
            }

            curr += next[0];
            drop.offer(next);

            if (curr > capacity) return false;
        }

        return true;
    }
}