class Solution {
    public void reverseString(char[] s) {
        int i = 0, y = s.length - 1;
        while(i < y){
            char a = s[i];
            char b = s[y];
            s[i] = b;
            s[y] = a;
            i++;
            y--;
        }
    }
}