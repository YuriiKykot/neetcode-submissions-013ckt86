class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            count.put(c, count.getOrDefault(c,0) + 1);
        }

        int need = count.size();
        int have = 0;
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c,0) + 1);

            if (count.containsKey(c) && window.get(c).equals(count.get(c))) {
                have++;
            }

            while (need == have) {
                if(right - left + 1 < resLen){
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char m = s.charAt(left);
                window.put(m, window.get(m) - 1);

                if(count.containsKey(m) && window.get(m) < count.get(m)){
                    have--;
                }

                left++;
            }
        }

        if(res[0] != -1) return s.substring(res[0], res[1] + 1);

        return "";
    }
}
