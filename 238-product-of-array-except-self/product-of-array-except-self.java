class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length], prefix = new int[nums.length], suffix = new int[nums.length];
        
        // prefix
        prefix[0] = 1;
        prefix[1] = nums[0];
        for(int x = 2; x < nums.length; x++){
            prefix[x] = nums[x - 1] * prefix[x - 1];
        }

        // suffix
        suffix[nums.length - 1] = 1;
        suffix[nums.length - 2] = nums[nums.length - 1];
        for(int y = nums.length - 3; y >= 0; y--){
            suffix[y] = nums[y + 1] * suffix[y + 1];
        }

        for(int a = 0; a < nums.length; a++) {
            ans[a] = prefix[a] * suffix[a];
        }
        return ans;
    }
}