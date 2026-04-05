class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        bfs(res,nums,new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    public void bfs(List<List<Integer>> l, int[] n, List<Integer> c, boolean[] pick){
        if(c.size() == n.length){
            l.add(new ArrayList<>(c));
            return;
        }

        for(int i = 0; i < n.length; i++){
            if(!pick[i]){
                c.add(n[i]);
                pick[i] = true;
                bfs(l,n,c,pick);
                c.remove(c.size() - 1);
                pick[i] = false;
            }
        }
    }
}
