class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, maxLen = 0;
        Map<Character, Integer> count = new HashMap<>();
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c,0) + 1);
            maxLen = Math.max(maxLen, count.get(c));

            while ((right - left + 1) - maxLen > k) {
                char m = s.charAt(left);
                count.put(m, count.get(m) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
