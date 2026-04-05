class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        String cols;
        String rows;
        int m;
        int n;
        
        if(text1.length() > text2.length()){
            m = text2.length();
            n = text1.length();
            rows = text2;
            cols = text1;
        }else{
            m = text1.length();
            n = text2.length();
            rows = text1;
            cols = text2;
        }

        int[] prevRow = new int[n+1];
        for(int i = 0; i < m; i++){
            int[] curRow = new int[n+1];
            for(int j = 1; j < n+1; j++){
                if(rows.charAt(i) == cols.charAt(j-1)){
                    curRow[j] = prevRow[j-1] + 1;
                }else{
                    curRow[j] = Math.max(prevRow[j], curRow[j-1]);
                }
            }
            prevRow = curRow;
        }

        return prevRow[n];
    }
}
