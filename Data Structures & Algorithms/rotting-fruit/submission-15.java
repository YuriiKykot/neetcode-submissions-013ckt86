class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null) return -1;

        int R = grid.length;
        int C = grid[0].length;

        Deque<int[]> q = new ArrayDeque<>();

        //int max = 0;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] != 2) continue;
                int[] start = {i,j};
                q.add(start);
            }
        }

        int l = -1;
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                int[] pair = q.poll();
                int x = pair[0];
                int y = pair[1];
                int[][] n = {{x+1,y},{x-1,y},{x,y-1},{x,y+1}};

                for(int j = 0; j < 4; j++){
                    int a = n[j][0];
                    int b = n[j][1];
                    if(a == R || b == C || Math.min(a,b) < 0 || grid[a][b] != 1) continue;
                    q.add(n[j]);
                    grid[a][b] = 2;
                }
            }
            l++;
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return l == -1 ? 0 : l;
    }
}
