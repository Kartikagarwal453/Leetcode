class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = points[i][0];
        }

        Arrays.sort(x);

        int maxW = 0;

        for (int i = 1; i < n; i++) {
            maxW = Math.max(maxW, x[i] - x[i - 1]);
        }

        return maxW;
    }
}