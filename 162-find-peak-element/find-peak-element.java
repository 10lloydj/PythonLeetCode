class Solution {
    public int findPeakElement(int[] nums) {

        if (nums.length == 1) return 0;
        int left = 0;
        int right = nums.length - 1;
        
        // check gradient of x - 1 to x, then head towards +
        while(left < right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }
}