class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int toImprove = 0;
        int totalHappy = 0;

        for(int i = 0; i < minutes; i++){
            if(grumpy[i] == 1){
                toImprove += customers[i];
            }else{
                totalHappy += customers[i];
            }
        }

        int res = toImprove;

        for(int i = minutes; i < customers.length; i++){
            if(grumpy[i - minutes] == 1){
                toImprove -= customers[i - minutes];
            }
            if(grumpy[i] == 1){
                toImprove += customers[i];
            }

            if(grumpy[i] == 0) totalHappy += customers[i];

            res = Math.max(res,toImprove);
        }

        return res + totalHappy;
    }
}