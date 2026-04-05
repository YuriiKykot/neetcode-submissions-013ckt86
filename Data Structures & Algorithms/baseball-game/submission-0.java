class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String op : operations){
            if(op.equals("+")){
                int top = stack.pop();
                int top2 = stack.pop();
                int newTop = top+top2;
                stack.push(top2);
                stack.push(top);
                stack.push(newTop);
            }else if(op.equals("D")){
                stack.push(2 * stack.peek());
            }else if(op.equals("C")){
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for(int i : stack){
            sum += i;
        }
        return sum;
    }
}