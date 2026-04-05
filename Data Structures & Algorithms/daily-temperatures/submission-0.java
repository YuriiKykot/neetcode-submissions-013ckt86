class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,temperatures[0]});

        for(int i = 1; i < temperatures.length; i++){
            while(!stack.isEmpty() && stack.peek()[1] < temperatures[i]){
                int[] t = stack.pop();
                res[t[0]] = i-t[0];
            }
            stack.push(new int[]{i,temperatures[i]});
        }

        return res;
    }
}
