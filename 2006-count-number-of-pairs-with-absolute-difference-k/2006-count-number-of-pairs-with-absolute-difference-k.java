class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int x : nums) {
            count += freq.getOrDefault(x - k, 0);
            count += freq.getOrDefault(x + k, 0);

            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        return count;
    }
}