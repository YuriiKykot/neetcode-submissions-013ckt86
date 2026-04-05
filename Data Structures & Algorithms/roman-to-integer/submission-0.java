class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int prev = 0;

        for(int i = 0; i < s.length(); i++){
            int num = getNum(s.charAt(i));

            if(prev == 0){
                sum += num;
            }else{
                sum += prev < num ? num - prev * 2 : num;
            }

            prev = num;
        }

        return sum;
    }

    int getNum(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}