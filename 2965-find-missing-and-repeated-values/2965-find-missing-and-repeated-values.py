class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n = len(grid)
        N = n * n

        expected_sum = N * (N + 1) // 2
        expected_sq_sum = N * (N + 1) * (2 * N + 1) // 6

        actual_sum = 0
        actual_sq_sum = 0

        for row in grid:
            for x in row:
                actual_sum += x
                actual_sq_sum += x * x

        diff = actual_sum - expected_sum          
        sq_diff = actual_sq_sum - expected_sq_sum 

        sum_ab = sq_diff // diff                 

        a = (diff + sum_ab) // 2
        b = (sum_ab - diff) // 2

        return [a, b]