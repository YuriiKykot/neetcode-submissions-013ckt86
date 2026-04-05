class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int size = s.length();
        for(int i = 0; i < size; i++){
            last[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> res = new ArrayList<>();
        int end = 0;
        int sizeE = 0;

        for(int i = 0; i < size; i++){
            sizeE++;
            end = Math.max(end, last[s.charAt(i) - 'a']);

            if(i == end){
                res.add(sizeE);
                sizeE = 0;
            }
        }

        return res;
    }
}
