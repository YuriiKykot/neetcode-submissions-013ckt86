class Solution {
    public int shortestWay(String s, String t) {
        for (char c : t.toCharArray()) {
            if (s.indexOf(c) == -1) return -1;
        }

        int count = 0;
        int j = 0;

        while(j < t.length()){
            count++;

            for(int i = 0; i < s.length() && j < t.length(); i++){
                if(s.charAt(i) == t.charAt(j)){
                    j++;
                }
            }
        }

        return count;
    }
}
