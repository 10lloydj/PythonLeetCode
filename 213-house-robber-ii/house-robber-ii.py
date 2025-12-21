class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 3:
            return max(nums)
        # create 2 memo lists (one for robbing the first house and not the last)
        # 2nd for robbing the 2nd and the last (potentially)
        memo1 = [0] * len(nums)
        memo2 = memo1.copy()
        memo1[0] = nums[0]
        memo1[1] = max(nums[0], nums[1])

        # (memo2[0] = 0)
        memo2[1] = nums[1]

        for i in range(2, len(nums) - 1):
            memo1[i] = max(memo1[i - 1], memo1[i - 2] + nums[i])

        for i in range(2, len(nums)):
            memo2[i] = max(memo2[i - 1], memo2[i - 2] + nums[i])

        return max(memo1[-2], memo2[-1])