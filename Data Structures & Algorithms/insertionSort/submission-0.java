// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        int n = pairs.size();
        List<List<Pair>> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int j = i - 1;
            while (j >= 0 && pairs.get(j).key > pairs.get(j+1).key){
                Pair jKey = pairs.get(j);
                Pair iKey = pairs.get(j+1);
                pairs.set(j, iKey);
                pairs.set(j+1, jKey);
                j--;
            }
            list.add(new ArrayList<>(pairs));
        }

        return list;
    }
}
