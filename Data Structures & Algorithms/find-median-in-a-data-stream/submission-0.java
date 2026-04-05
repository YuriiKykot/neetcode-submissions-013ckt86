class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        this.min = new PriorityQueue<>();
        this.max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(min.size() == 0 && max.size() == 0) {
            max.offer(num);
            return;
        }

        if(max.peek() > num){
            max.offer(num);
        }else{
            min.offer(num);
        }

        if(min.size() < max.size() - 1){
            min.offer(max.poll());
        }

        if(max.size() < min.size() - 1){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {

        if(max.size() > min.size()){
            return max.peek();
        }else if(max.size() < min.size()){
            return min.peek();
        }else{
            double val = (max.peek() + min.peek()) / 2.0;
            return val;
        }
    }
}
