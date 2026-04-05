class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        int[] largest;
        int[] smalest;

        if(nums1.length > nums2.length){
            largest = nums1;
            smalest = nums2;
        }else{
            largest = nums2;
            smalest = nums1;
        }

        Arrays.sort(largest);
        Arrays.sort(smalest);

        for(int i = 0; i < smalest.length; i++){
            if(set.contains(smalest[i])) continue;

            int l = 0;
            int r = largest.length - 1;

            int k = smalest[i];

            while(l <= r){
                int m = l + (r - l)/2;

                int larg = largest[m];

                if(larg == k){
                    set.add(larg);
                    break;
                }

                if(larg > k){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}