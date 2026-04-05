class Solution {
    private int[] n;

    public int[] sortArray(int[] nums) {
        if(nums.length <= 1) return nums;

        this.n = nums;

        mergeSort(0,n.length-1);

        return n;
    }

    public void mergeSort(int l, int r){
        if(l >= r) return;

        int mid = (r + l) / 2;

        mergeSort(l,mid);
        mergeSort(mid+1,r);
        merge(l,mid,r);
    }

    public void merge(int l, int mid, int r){
        int temp[] = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= r){
            if(n[i] < n[j]){
                temp[k++] = n[i++];
            }else{
                temp[k++] = n[j++];
            }
        }

        while(i <= mid){
            temp[k++] = n[i++];
        }
        while(j <= r){
            temp[k++] = n[j++];
        }

        for(int z = 0; z < temp.length; z++){
            n[l + z] = temp[z];
        }
    }
}