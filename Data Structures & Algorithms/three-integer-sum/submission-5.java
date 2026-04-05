class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < l; i++){
            //if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int x = i + 1;
            int y = l - 1;

            while(x < y){
                int sum = nums[x]+nums[y]+nums[i];

                if(sum > 0){
                    y--; 
                }else if(sum < 0){
                    x++;
                }else{
                    List<Integer> list = new ArrayList<>();

                    list.add(nums[i]);
                    list.add(nums[x]);
                    list.add(nums[y]);

                    res.add(list);

                    x++;
                    y--;
                    while (x < y && nums[x] == nums[x - 1]) {
                        x++;
                    }
                }
            }
        }

        return res;
    }
}
