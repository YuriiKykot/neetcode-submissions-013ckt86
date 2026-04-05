class Solution {
    record Point(int x, int y, double score){}

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(Comparator.comparingDouble(Point::score).reversed());

        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int x1 = 0 - x;
            int y1 = 0 - y;
            double score = Math.sqrt((x1*x1)+(y1*y1));

            maxHeap.offer(new Point(x,y,score));

            if(maxHeap.size() > k) maxHeap.poll();
        }

        int[][] arr = new int[k][2];

        int i = 0;
        for(Point p : maxHeap){
            arr[i][0] = p.x;
            arr[i][1] = p.y;
            i++;
        }

        return arr;
    }
}
