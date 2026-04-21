class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < size; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < size; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1;
                int r = size - 1;

                while(l < r){
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

                    if(sum > target){
                        r--;
                    }else if(sum < target){
                        l++;
                    }else if(sum == target){
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r])));

                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                    }
                }
            }
        }

        return res;
    }
}