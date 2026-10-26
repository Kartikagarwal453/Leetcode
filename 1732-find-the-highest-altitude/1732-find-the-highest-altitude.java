class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int ans = 0;

        for (int g : gain) {
            sum += g;
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}