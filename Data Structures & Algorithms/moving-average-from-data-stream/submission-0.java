class MovingAverage {
    Queue<Integer> q;
    int size;

    public MovingAverage(int size) {
        this.q = new LinkedList<>();
        this.size = size;
    }
    
    public double next(int val) {
        if(q.size() >= size) q.poll();
        q.offer(val);

        double sum = 0;
        int s = q.size();
        int i = s;

        while(!q.isEmpty() && i-- != 0){
            int x = q.poll();
            q.offer(x);
            sum += x;
        }

        return sum / s;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
