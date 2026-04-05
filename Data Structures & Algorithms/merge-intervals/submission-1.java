class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();

        if(intervals.length < 2) return intervals;

        int i = 0;
        while(i < intervals.length){
            if(i + 1 >= intervals.length){
                list.add(new int[]{intervals[i][0], intervals[i][1]});
                break;
            }

            int j = 0;
            if(intervals[i][1] >= intervals[i+1][0] 
                    && intervals[i][0] <= intervals[i+1][1]){

                int[] cur = new int[2];
                cur[0] = Math.min(intervals[i][0],intervals[i+1][0]);
                cur[1] = Math.max(intervals[i][1],intervals[i+1][1]);
                j = i;
                
                while(j < intervals.length){
                    j++;
                    if(j + 1 >= intervals.length) break;

                    if(cur[1] >= intervals[j+1][0]
                            && cur[0] <= intervals[j+1][1]){
                        cur[0] = Math.min(cur[0],intervals[j+1][0]);
                        cur[1] = Math.max(cur[1],intervals[j+1][1]);
                    }else{
                        break;
                    }
                }

                list.add(new int[]{cur[0], cur[1]});
            }else{
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }

            i = j > i ? ++j : ++i;
        }

        return list.toArray(new int[list.size()][]);
    }
}
