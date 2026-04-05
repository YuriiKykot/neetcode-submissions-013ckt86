class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        dfs(res,cur,0,s);
        return res;
    }

    public void dfs(List<List<String>> res, List<String> cur, int i, String s){
        if(i >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(isPali(s, i, j)){
                cur.add(s.substring(i,j+1));
                dfs(res,cur,j+1,s);
                cur.remove(cur.size()-1);
            }
        }
    }

    public boolean isPali(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
