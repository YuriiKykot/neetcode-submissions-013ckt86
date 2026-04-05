class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, last = m + n - 1;

        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[last] = nums1[i]; 
                i--;
            }else{
                nums1[last] = nums2[j];
                j--;
            }
            last--;
            for(int v = 0; v < m + n; v++){
                System.out.print(nums1[v] + " ");
            }
            System.out.println("");
        }

        while(last >= 0 && j >= 0){
            nums1[last] = nums2[j];
            last--;
            j--;
        }
    }
}