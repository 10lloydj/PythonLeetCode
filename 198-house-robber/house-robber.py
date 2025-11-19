class Solution:
    def rob(self, nums: List[int]) -> int:
        # memoize each best result
        # to calculate the current house look at the previous adjacent house and the previous before
        # and add it to the value of the current house

        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums)
        memo = [0] * len(nums)
        memo[0] = nums[0]
        memo[1] = nums[1]
        memo[2] = memo[0] + nums[2]

        for current in range(3, len(nums)):
            memo[current] = max(memo[current - 2], memo[current - 3]) + nums[current]

        return max(memo)