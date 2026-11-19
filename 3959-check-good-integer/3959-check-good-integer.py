class Solution:
    def checkGoodInteger(self, n: int) -> bool:
        digitSum = 0
        squareSum = 0

        while n > 0:
            digit = n % 10
            digitSum += digit
            squareSum += digit * digit
            n //= 10

        return squareSum - digitSum >= 50