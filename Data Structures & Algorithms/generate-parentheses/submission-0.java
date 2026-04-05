class Solution {
    private static StringBuilder stack;
    private static List<String> res;
    private static int n;

    public List<String> generateParenthesis(int n) {
        this.stack = new StringBuilder();
        this.res = new ArrayList<>();
        this.n = n;

        backtrack(0,0);
        return this.res;
    }

    public void backtrack(int openN, int closeN){
        if(openN == n && closeN == n){
            res.add(stack.toString());
            return;
        }

        if(openN < n){
            stack.append("(");
            backtrack(openN + 1, closeN);
            stack.deleteCharAt(stack.length() - 1);
        }

        if(closeN < openN){
            stack.append(")");
            backtrack(openN, closeN + 1);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
