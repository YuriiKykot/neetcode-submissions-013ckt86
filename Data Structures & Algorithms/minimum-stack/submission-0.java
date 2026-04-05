class MinStack {

    List<Integer> stack = new ArrayList<>();
    List<Integer> stackMin = new ArrayList<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.add(val);
        if (stackMin.isEmpty()) {
            stackMin.add(val);
        } else {
            stackMin.add(Math.min(val, stackMin.get(stackMin.size() - 1)));
        }
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
        popMin();
    }

    public void popMin(){
        stackMin.remove(stackMin.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }

    public int topMin(){
        return stackMin.get(stackMin.size()-1);
    }
    
    public int getMin() {
        return topMin();
    }
}
