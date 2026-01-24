class Solution {
    public int longestSubarray(int[] nums) {
        int best = 0, l = 0;
        int delLeft = 1;

        for(int r = 0; r < nums.length; r++) {

            if(nums[r] == 0) {
                delLeft--;
            }

            while (delLeft < 0) {
                if (nums[l] == 0) {
                    delLeft++;
                }
                l++;
            }

            // if delLeft = 1 and best < length. best is still the same
            if (delLeft == 1 && (r - l + 1) < nums.length) {
                best = Math.max(best, r - l + 1);
            } else {
                // if delLeft = 0 best - 1
                best = Math.max(best, r - l);
            }
        }
        return best;
    }
}