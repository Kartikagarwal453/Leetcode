class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums2) {
            freq.put(num * k, freq.getOrDefault(num * k, 0) + 1);
        }

        int count = 0;

        for (int num : nums1) {
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (num % entry.getKey() == 0) {
                    count += entry.getValue();
                }
            }
        }

        return count;
    }
}