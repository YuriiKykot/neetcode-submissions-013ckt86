class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y+x);
            }else if(s.equals("-")){
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y-x);
            }else if(s.equals("*")){
                int x = stack.pop();
                int y = stack.pop();
                stack.push(x*y);
            }else if(s.equals("/")){
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y/x);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
