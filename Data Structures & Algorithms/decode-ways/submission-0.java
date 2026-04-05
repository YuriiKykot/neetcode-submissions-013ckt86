class Solution {
    public int numDecodings(String s) {
        return dfs(0,s);
    }

    public int dfs(int i, String s){
        int len = s.length();
        if(len <= i) return 1;
        if(s.charAt(i) == '0') return 0;

        int res = 0;

        //res += dfs(i+1,s);
        if(len > i + 1 && s.charAt(i) == '0'){
            if(s.charAt(i) == '0') i++;
        }else if(len > i + 1 && Integer.parseInt(s.substring(i, i+2)) <= 26){
            res += dfs(i+2,s);
        }

        res += dfs(i+1,s);

        return res;
    }
}
