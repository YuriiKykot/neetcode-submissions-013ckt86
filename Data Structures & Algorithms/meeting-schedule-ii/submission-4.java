/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for(Interval i : intervals){
            q.offer(new int[]{i.start,1});
            q.offer(new int[]{i.end,-1});
        }
        
        int count = 0;
        int res = 0;

        while(!q.isEmpty()){
            count += q.poll()[1];
            res = Math.max(count,res);
        }

        return res;
    }
}
