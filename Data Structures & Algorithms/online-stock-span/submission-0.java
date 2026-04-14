class StockSpanner {

    private Stack<int[]> spans;

    public StockSpanner() {
        this.spans = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        while(!spans.isEmpty() && spans.peek()[0] <= price){
            span += spans.pop()[1];
        }

        spans.push(new int[]{price,span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */