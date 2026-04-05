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
        PriorityQueue<Integer> start = new PriorityQueue<>();
        PriorityQueue<Integer> end = new PriorityQueue<>();
        int res = 0, count = 0;

        for(Interval i : intervals){
            start.offer(i.start);
            end.offer(i.end);
        }

        while (!start.isEmpty()) {
            count++;
            if(start.peek() >= end.peek()){ 
                count--;
                end.poll();
            }
            start.poll();
            res = Math.max(res,count);
        }


        return res;
    }
}
