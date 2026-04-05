class Solution {
    public int[] plusOne(int[] digits) {
        int mem = 1;

        for(int i = digits.length - 1; i >= 0; i--){
            int res = digits[i] + mem;
            int digit = res % 10;
            mem = res / 10;
            digits[i] = digit;
        }
        if(mem != 0){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }

        return digits;
    }
}
