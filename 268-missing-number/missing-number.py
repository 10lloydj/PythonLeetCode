class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        # edge case size is 1
        if len(nums) == 1:
            if nums[0] == 0:
                return 1
            else:
                return 0    
        # sort the list, then if n - (n - 1) > 1? then the number between both is missing 
        nums.sort()
        if nums[0] != 0:
            return 0
        for n in range(1, len(nums)):
            if nums[n] - nums[n-1] > 1:
                return nums[n-1] + 1
        
        return nums[len(nums) - 1] + 1
        