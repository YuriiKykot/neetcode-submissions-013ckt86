class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] priority = new int[tasks.length][2];

        for(int i = 0; i < priority.length; i++){
            priority[i][0] = i;
            priority[i][1] = tasks[i][0];
        }

        Arrays.sort(priority, (a, b) -> a[1] - b[1]); 

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]
        );

        int j = 0;
        int[] res = new int[tasks.length];
        int idx = 0;
        int time = 0;

        while(idx < tasks.length){
            while(j < tasks.length && priority[j][1] <= time){
                pq.offer(new int[]{priority[j][0], tasks[priority[j][0]][1]});
                j++;
            }

            if(pq.isEmpty()){
                time = priority[j][1];
            }else{
                int[] task = pq.poll();
                res[idx++] = task[0];
                time += task[1];
            }
        }

        return res;
    }
}