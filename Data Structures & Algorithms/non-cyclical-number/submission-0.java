class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            int sum = 0;
            int number = n;

            while (number > 0) {
                int digit = number % 10;
                sum += digit * digit;
                number /= 10;
            }

            if (seen.contains(sum)) return false;
            seen.add(sum);
            n = sum;
        }
        return true;
    }
}
