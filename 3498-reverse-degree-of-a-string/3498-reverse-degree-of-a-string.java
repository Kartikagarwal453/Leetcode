class Solution {
    public int reverseDegree(String s) {
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            int reverseValue = 'z' - c + 1;

            total += reverseValue * (i + 1);
        }

        return total;
    }
}