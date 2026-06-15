class Solution {
    List<String> res;
    Set<String> set;

    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        set = new HashSet<>(wordDict);
        List<String> cur = new ArrayList<>();

        backtrack(s, 0, cur);
        
        return res;
    }

    public void backtrack(String s, int i, List<String> cur){
        if(i == s.length()){
            res.add(String.join(" ", cur));
            return;
        }

        for(int j = i; j < s.length(); j++){
            String w = s.substring(i, j + 1);
            if(set.contains(w)){
                cur.add(w);
                backtrack(s, j + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}