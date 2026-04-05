// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return quickSort(pairs,0,pairs.size() - 1);
    }

    public List<Pair> quickSort(List<Pair> l, int s, int e){
        if(e - s + 1 <= 1) return l;

        Pair pivot = l.get(e);
        int left = s;

        for(int i = s; i < e; i++){
            if(l.get(i).key < pivot.key){
                Pair tmp = l.get(left);
                l.set(left, l.get(i));
                l.set(i, tmp);
                left++;
            }
        }

        l.set(e, l.get(left));
        l.set(left, pivot);

        quickSort(l,s,left-1);
        quickSort(l,left+1,e);

        return l;
    }
}
