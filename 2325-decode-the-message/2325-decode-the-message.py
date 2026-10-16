class Solution:
    def decodeMessage(self, key: str, message: str) -> str:
        mapping = {}
        alphabet = 'abcdefghijklmnopqrstuvwxyz'
        index = 0

        for char in key:
            if char != ' ' and char not in mapping:
                mapping[char] = alphabet[index]
                index += 1

        result = ''

        for char in message:
            if char == ' ':
                result += ' '
            else:
                result += mapping[char]

        return result