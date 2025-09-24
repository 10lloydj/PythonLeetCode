class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        def check(start, end):
            chars = set()
            for c in range(start, end + 1):
                current = s[c]
                if current in chars:
                    return False
                chars.add(current)
            return True
        n = len(s)

        res = 0

        # sliding window
        left = 0
        right = 0
        while right < n:
            if check(left, right):
                res = max(res, right - left + 1)
                right = right + 1
            else:
                left = left + 1

        return res
