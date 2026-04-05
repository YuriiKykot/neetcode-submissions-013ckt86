class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int cur = intervals[0][1];

        int res = 0;

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < cur){
                res++;
            }else{
                cur = intervals[i][1];
            }
        }

        return res;
    }
}
