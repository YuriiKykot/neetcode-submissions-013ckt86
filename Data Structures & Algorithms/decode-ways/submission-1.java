class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);

        return dfs(0,s,dp);
    }

    public int dfs(int i, String s, Map<Integer, Integer> dp){
        if(dp.containsKey(i)) return dp.get(i);

        int len = s.length();
        if(s.charAt(i) == '0') return 0;

        int res = dfs(i+1,s,dp);

        //res += dfs(i+1,s);
        //if(len > i + 1 && s.charAt(i) == '0'){
            //if(s.charAt(i) == '0') i++;
        if(len > i + 1 && Integer.parseInt(s.substring(i, i+2)) <= 26){
            res += dfs(i+2,s,dp);
        }

        //res += dfs(i+1,s);
        dp.put(i,res);

        return res;
    }
}
