class Solution:
    def longestPalindrome(self, s: str) -> str:
        longest = s[0]

        def expand(left, right):
            max_len = 1
            start = 0
            while left >= 0 and right < len(s) and s[left] == s[right]:
                current_len = right - left + 1
                if current_len > max_len:
                    max_len = current_len
                    start = left
                left -= 1
                right += 1
            return s[start: start + max_len]

        for i in range(len(s)):
            odd_pal = expand(i, i)
            even_pal = expand(i, i + 1)

            if len(odd_pal) > len(longest):
                longest = odd_pal
            if len(even_pal) > len(longest):
                longest = even_pal
        return longest