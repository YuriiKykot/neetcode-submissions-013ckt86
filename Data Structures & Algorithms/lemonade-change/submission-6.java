class Solution {
    public boolean lemonadeChange(int[] bills) {
        int ten = 0;
        int five = 0;

        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == 5){
                five++;
            }else if(bills[i] == 10){
                if(five == 0) return false;
                five--;
                ten++;
            }else{
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                    continue;
                }
                if(five >= 3){
                    five -= 3;
                    continue;
                }
                return false;
            }
        }

        return true;
    }
}