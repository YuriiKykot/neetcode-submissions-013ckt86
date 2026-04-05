class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int sLen = s.length();

        for(int i = 0; i < sLen; i++){

            int l = i, r = i;
            while(l >= 0 && r < sLen && 
                    s.charAt(l) == s.charAt(r)){
                res++;
                l--;
                r++;
            }

            l = i;
            r = i+1;
            while(l >= 0 && r < sLen && 
                    s.charAt(l) == s.charAt(r)){
                res++;
                l--;
                r++;
            }
        }

        return res;
    }
}
