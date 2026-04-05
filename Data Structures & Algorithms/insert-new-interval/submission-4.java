class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean added = false;

        if(intervals.length == 0){
            list.add(newInterval);
        }

        for(int i = 0; i < intervals.length; i++){
            int x = intervals[i][0];
            int y = intervals[i][1];

            if(x <= newInterval[1] && newInterval[0] <= y){
                newInterval[0] = Math.min(x,newInterval[0]);
                newInterval[1] = Math.max(y,newInterval[1]);
            }else{
                

                if(x > newInterval[0] && !added){
                    added = true;
                    list.add(newInterval);
                }

                list.add(new int[]{x, y});
            }

            if(i == intervals.length - 1 && !added) list.add(newInterval);
        }

        return list.toArray(new int[list.size()][]);
    }
}
