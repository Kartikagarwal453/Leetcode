class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;

        for (int num : nums) {
            String s = String.valueOf(num);

            for (char c : s.toCharArray()) {
                if (c - '0' == digit) {
                    count++;
                }
            }
        }

        return count;
    }
}