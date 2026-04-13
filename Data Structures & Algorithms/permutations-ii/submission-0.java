class Solution {
    private int S;
    private Map<Integer,Integer> counts;
    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.counts = new HashMap<>();
        this.res = new ArrayList<>();

        this.S = nums.length;

        for(int num : nums){
            counts.put(num,counts.getOrDefault(num,0)+1);
        }

        dfs(new ArrayList<>());

        return res;
    }

    public void dfs(List<Integer> curent){
        if(curent.size() == S){
            res.add(new ArrayList<>(curent));
            return;
        }

        for (int num : counts.keySet()) {
            if(counts.get(num) > 0){
                curent.add(num);
                counts.put(num,counts.get(num)-1);

                dfs(curent);

                curent.remove(curent.size()-1);
                counts.put(num,counts.get(num)+1);
            }
        }
    }
}