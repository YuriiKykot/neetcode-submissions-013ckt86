class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> s = new HashSet<>();

        for(int i : nums){
            s.add(i);
        }

        int c = 1;
        for(Integer n : s){
            if(!s.contains(n-1)){
                while(s.contains(n+c)) c++;
                max = Math.max(max,c);
                c = 1;
            }
        }

        return max;
    }
}
