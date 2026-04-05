class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int r = grid.length, c = grid[0].length;

        boolean[][] visited = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }

        int distance = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cord = q.poll();
                int x = cord[0];
                int y = cord[1];

                grid[x][y] = distance;
                visited[x][y] = true;

                addRoom(x + 1, y, grid, visited, q, r, c);
                addRoom(x - 1, y, grid, visited, q, r, c);
                addRoom(x, y + 1, grid, visited, q, r, c);
                addRoom(x, y - 1, grid, visited, q, r, c);
            }
            distance++;
        } 
    }

    public void addRoom(int x, int y, int[][] grid, boolean[][] visited, Queue<int[]> q, int r, int c){
        if(x < 0 || x >= r || y < 0 || y >= c || visited[x][y] || grid[x][y] == -1 || grid[x][y] == 0) return;

        visited[x][y] = true;
        q.offer(new int[]{x,y});
    }
}
