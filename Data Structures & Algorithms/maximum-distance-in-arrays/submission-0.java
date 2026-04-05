class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;

        int size = arrays.get(0).size();
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(size - 1);
        for(int i = 1; i < arrays.size(); i++){
            size = arrays.get(i).size();;

            int localMin = arrays.get(i).get(0);
            int localMax = arrays.get(i).get(size - 1);

            int abs1 = Math.abs(localMax - min);
            int abs2 = Math.abs(max - localMin);

            int maxAbs = Math.max(abs1,abs2);
            res = Math.max(res,maxAbs);

            min = Math.min(localMin,min);
            max = Math.max(localMax,max);
        }

        return res;
    }
}
