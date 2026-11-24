
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);

            if (s.length() % 2 != 0) {
                continue;
            }

            int n = s.length() / 2;
            int firstSum = 0, secondSum = 0;

            for (int j = 0; j < n; j++) {
                firstSum += s.charAt(j) - '0';
                secondSum += s.charAt(j + n) - '0';
            }

            if (firstSum == secondSum) {
                count++;
            }
        }

        return count;
    }
}
