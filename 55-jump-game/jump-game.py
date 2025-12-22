class Solution:
    def canJump(self, nums: List[int]) -> bool:
        m = len(nums)
        goal = m - 1
        for i in range(2, m + 1, 1):
            # can m - i reach goal, then move goal the current index
            if nums[m - i] + (m - i) >= goal:
                goal = m - i
        
        if goal == 0:
            return True
        return False