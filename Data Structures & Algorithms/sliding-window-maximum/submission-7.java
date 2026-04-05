class Solution {
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     k = k - 1;
    //     int steps = nums.length - k;
    //     int[] res = new int[steps];

    //     for(int i = k; i < nums.length; i++){
    //         int max = nums[i - k];
    //         for(int j = i - k + 1; j <= i; j++){
    //             max = Math.max(max,nums[j]);
    //         }
    //         res[i - k] = max;
    //     }

    //     return res; 
    // }

    // public int[] maxSlidingWindow(int[] nums, int k) {

    //     k = k - 1;
    //     int len = nums.length;
    //     int[] res = new int[len - k];
    //     Deque<Integer> q = new LinkedList<>();

    //     for(int i = 0; i < len; i++){
    //         while(!q.isEmpty() && q.size() > k){
    //             q.removeLast();
    //         }

    //         if(!q.isEmpty() && q.getFirst() > nums[i]){
    //             q.addLast(nums[i]);
    //         }else{
    //             q.addFirst(nums[i]);
    //         }

    //         if(i >= k){
    //             res[i - k] = q.getFirst();
    //         }
    //     }       
        
    //     return res;
    // }

    public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) return new int[0];
    
    int n = nums.length;
    int[] res = new int[n - k + 1];
    Deque<Integer> q = new LinkedList<>(); // зберігаємо індекси

    for (int i = 0; i < n; i++) {
        // Видаляємо індекси, які вийшли з вікна
        while (!q.isEmpty() && q.getFirst() < i - k + 1) {
            q.removeFirst();
        }

        // Видаляємо всі елементи менші за nums[i]
        while (!q.isEmpty() && nums[q.getLast()] < nums[i]) {
            q.removeLast();
        }

        q.addLast(i);

        // Додаємо максимум у результат
        if (i >= k - 1) {
            res[i - k + 1] = nums[q.getFirst()];
        }
    }

    return res;
}
}
