class Solution {
    public int minimumRecolors(String blocks, int k) {
        int cur = 0;

        for(int i = 0; i < k; i++){
            if(blocks.charAt(i) == 'W')
                cur++;
        }

        int res = cur;

        System.out.println(res);

        for(int i = k; i < blocks.length(); i++){
            if(blocks.charAt(i - k) == 'W') cur--;
            if(blocks.charAt(i) == 'W') cur++;

            res = Math.min(res,cur);
        }

        return res;
    }
}