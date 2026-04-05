class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> map = new TreeMap<>();

        for(int i : hand){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }
        }

        Arrays.sort(hand);
        for(int num : hand){
            if(map.get(num) > 0){
                for(int i = num; i < num + groupSize; i++){
                    if(!map.containsKey(i) || map.get(i) == 0) return false;
                    map.put(i,map.get(i)-1);
                }
            } 
        }

        return true;
    }
}
