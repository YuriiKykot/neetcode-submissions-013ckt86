class Solution {
    public int lengthOfLongestSubstring(String s) {

        Queue<Character> list = new ArrayDeque<>();
        int max = 0;

        for(int i = 0; i < s.length(); i++){
            System.out.println(list);
            if(list.contains(s.charAt(i))){
                max = Math.max(max,list.size());
                while(list.contains(s.charAt(i))) list.poll();
            }
            list.offer(s.charAt(i));
        }

        max = Math.max(max,list.size());

        return max;
    }
}
