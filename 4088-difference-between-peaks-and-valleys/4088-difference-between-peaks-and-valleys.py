class Solution:
    def peakValleyDifference(self, nums: list[int]) -> int:
        peak_sum = 0
        valley_sum = 0

        for i in range(1, len(nums) - 1):
            if nums[i] > nums[i - 1] and nums[i] > nums[i + 1]:
                peak_sum += nums[i]

            elif nums[i] < nums[i - 1] and nums[i] < nums[i + 1]:
                valley_sum += nums[i]

        return peak_sum - valley_sum