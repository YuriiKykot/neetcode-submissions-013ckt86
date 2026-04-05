class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        Map<Character,Integer> count = new HashMap<>();

        int l = 0;
        int res = 0;

        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);

            count.put(c, count.getOrDefault(c,0) + 1);

            while(r - l + 1 > k || count.get(c) > 1){
                char i = s.charAt(l);
                count.put(i, count.get(i) - 1);
                if(count.get(i) == 0) count.remove(i);
                l++;
            }

            res += r - l + 1 == k ? 1 : 0;
        }

        return res;
    }
}
