class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        switch (nums.length) {
            case 0:
                return 0;
            case 1:
                return nums[0];
            case 2:
                return Math.max(nums[0], nums[1]);
            default:
                break;
        }
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for(int x = 2; x < nums.length; x++) {
            memo[x] = Math.max(memo[x -1 ], memo[x - 2] + nums[x]);
        }

        return memo[nums.length - 1];
    }
}