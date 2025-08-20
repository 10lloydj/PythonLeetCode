class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        x, y = len(text1), len(text2)
        dp = [[0] * (x + 1) for _ in range(y + 1)]
        for b in range(1, y + 1):
            for a in range(1, x + 1):
                if text1[a - 1] == text2[b - 1]:
                    dp[b][a] = 1 + dp[b - 1][a - 1]
                else:
                    dp[b][a] = max(dp[b - 1][a], dp[b][a - 1])
        return dp[y][x]
