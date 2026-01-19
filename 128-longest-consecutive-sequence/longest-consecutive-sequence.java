class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        // hashset
        HashSet<Integer> set = new HashSet<Integer>();
        for(int x: nums) {
            set.add(x);
        }
        int max = 0;
        int current;
        int count;
        // check if current has a lower value, then go up
        for(int a : set) {
            current = a;
            count = 1;
            // iterates to the 'lowest' value
            if (set.contains(current - 1)) {
                continue;
            }

            while (set.contains(current + 1)) {
                count++;
                current++;
            }
            max = Math.max(count, max);
        }

        return max;
    }
}