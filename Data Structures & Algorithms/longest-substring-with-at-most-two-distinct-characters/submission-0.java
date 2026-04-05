class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> count = new HashMap<>();

        int l = 0;
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);

            count.put(cur, count.getOrDefault(cur,0) + 1);

            while(count.size() > 2){
                char r = s.charAt(l);
                count.put(r, count.get(r) - 1);
                if(count.get(r) == 0) count.remove(r);
                l++;
            }

            res = Math.max(res, i - l + 1);
        }

        return res;
    }
}