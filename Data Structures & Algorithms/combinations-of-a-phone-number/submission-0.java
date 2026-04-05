class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
        };
        if(digits.isEmpty()) return res;
        dfs(0,"",res,digits,digitToChar);
        return res;
    }

    public void dfs(int k, String cur, List<String> res, String dig, String[] charsArr){
        if(cur.length() == dig.length()){
            res.add(cur);
            return;
        }
        String chars = charsArr[dig.charAt(k) - '0'];
        for(char c : chars.toCharArray()){
            dfs(k + 1, cur + c, res, dig, charsArr);
        }
    }
}
