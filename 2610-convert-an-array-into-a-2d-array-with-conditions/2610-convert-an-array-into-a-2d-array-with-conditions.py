class Solution:
    def findMatrix(self, nums: list[int]) -> list[list[int]]:
        rows = []
        freq = defaultdict(int)

        for num in nums:
            if freq[num] == len(rows):
                rows.append([])

            rows[freq[num]].append(num)
            freq[num] += 1

        return rows
