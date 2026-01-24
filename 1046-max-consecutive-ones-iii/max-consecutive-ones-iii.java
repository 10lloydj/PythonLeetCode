class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        int best = 0, l = 0, kLeft = k;
        
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                kLeft--;
            }

            while(kLeft < 0) {
                if(nums[l] == 0) {
                    kLeft++;
                }
                l++;
            }

            best = Math.max(best, r - l + 1);
        }
        return best;
    }
}