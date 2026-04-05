class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int R = grid.length;
        int min = Integer.MAX_VALUE;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[2]);
        grid[0][0] = 1;

        return path(q,R,grid);
    }

    public int path(Deque<int[]> q, int R, int[][] grid){
        int l = 1;
        while(!q.isEmpty()){
            int queueLength = q.size();
            for (int j = 0; j < queueLength; j++) {
                int[] p = q.poll();
                int r = p[0], c = p[1];
                if(r == R - 1 && c == R - 1) return l;

                int[][] n = {{r + 1, c},{r - 1, c},{r, c + 1},{r, c - 1},
                                {r + 1, c + 1},{r - 1, c + 1},{r + 1, c - 1},{r - 1, c - 1}};

                for(int i = 0; i < 8; i++){
                    int x = n[i][0];
                    int y = n[i][1];
                    if(x == R || y == R || Math.min(x,y) < 0 || grid[x][y] != 0) continue;
                    q.add(n[i]);
                    grid[x][y] = 1;
                }   
            }

            l++;
        }

        return -1;
    }
}