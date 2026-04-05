class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });

        List<int[]> res = new ArrayList<>();

        for(int r = 0; r < intervals.length; r++){
            queue.offer(new int[]{intervals[r][0],intervals[r][1]});
        }


        int[] tmp = queue.poll();
        System.out.println(tmp[0] + " " + tmp[1]);
        while(!queue.isEmpty()){
            int[] curent = queue.poll();

            System.out.println(curent[0] + " " + curent[1]);

            if(tmp[1] >= curent[0]){
                tmp[0] = Math.min(tmp[0],curent[0]);
                tmp[1] = Math.max(tmp[1],curent[1]);
            }else{
                res.add(tmp);
                tmp = curent;
                //res.add(tmp);
            }
        }

        res.add(tmp);

        return res.toArray(new int[0][]);
        
    }
}
