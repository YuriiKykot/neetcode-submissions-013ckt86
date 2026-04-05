class Solution {
    public int shortestPath(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int[][] v = new int[R][C];
        Deque<int[]> q = new ArrayDeque<>();

        q.add(new int[2]);
        v[0][0] = 1;

        int l = 0;
        while(!q.isEmpty()){
            int queueLength = q.size();
            for (int j = 0; j < queueLength; j++) {
                int[] p = q.poll();
                int r = p[0], c = p[1];
                if(r == R - 1 && c == C - 1) return l;

                int[][] n = {{r + 1, c},{r - 1, c},{r, c + 1},{r, c - 1}};

                for(int i = 0; i < 4; i++){
                    int x = n[i][0];
                    int y = n[i][1];
                    if(x == R || y == C || Math.min(x,y) < 0 || v[x][y] != 0 || grid[x][y] != 0) continue;
                    q.add(n[i]);
                    v[x][y] = 1;
                }   
            }

            l++;
        }

        return -1;
    }
}
