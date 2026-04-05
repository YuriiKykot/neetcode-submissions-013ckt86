class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        StringBuilder sb = new StringBuilder(String.valueOf(x));

        int l = 0;
        int r = sb.length() - 1;

        while(l < r){
            if(sb.charAt(l) != sb.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}