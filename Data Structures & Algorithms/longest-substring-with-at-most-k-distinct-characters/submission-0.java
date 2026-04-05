class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();

        int l = 0;
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c,0) + 1);

            while(map.size() > k){
                char toRemove = s.charAt(l);
                map.put(toRemove, map.get(toRemove) - 1);
                if(map.get(toRemove) == 0) map.remove(toRemove);
                l++;
            }

            res = Math.max(res, i - l + 1);
        }

        return res;
    }
}
