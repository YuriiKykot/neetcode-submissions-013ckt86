class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.offer(x);
    }
    
    public int pop() {
        int val = -1;
        int k = queue.size();

        for(int i = 0; i < k; i++){
            if(i == k-1){
                val = queue.poll();
                break;
            }
            queue.offer(queue.poll());
        }

        return val;
    }
    
    public int top() {
        int val = -1;
        int k = queue.size();

        for(int i = 0; i < k; i++){
            if(i == k-1){
                val = queue.peek();
            }
            queue.offer(queue.poll());
        }

        return val;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */