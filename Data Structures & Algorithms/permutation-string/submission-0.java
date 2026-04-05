class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);

        for(int i = k; i <= s2.length(); i++){
            char[] tmp = s2.substring(i-k,i).toCharArray();
            Arrays.sort(tmp);
            if(Arrays.equals(arr1, tmp)) return true;
        }

        return false;
    }
}
