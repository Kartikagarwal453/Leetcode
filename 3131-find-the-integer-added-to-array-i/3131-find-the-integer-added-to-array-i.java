class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int x = nums2[0] - nums1[0];

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] + x != nums2[i]) {
                return x;
            }
        }

        return x;
    }
}