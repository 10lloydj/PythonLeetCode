class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        if len(coins) == 1:
            return amount // coins[0] if amount % coins[0] == 0 else -1
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        for i in range(0, amount + 1):
            for c in coins:
                if i - c >=  0:
                    # If we want to find i, we can see previous amounts solved
                    # with i - c (the difference) then we would add 1 coin. thus,
                    # dp[i - c] + 1
                    dp[i] = min(dp[i], dp[i - c] + 1)

        return dp[amount] if dp[amount] != float('inf') else -1
