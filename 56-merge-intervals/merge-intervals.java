import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Add first interval
        merged.add(intervals[0]);

        // Iterate from second interval onward
        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size() - 1);
            int[] current = intervals[i];

            // No overlap
            if (current[0] > last[1]) {
                merged.add(current);
            } else {
                // Overlap → merge by extending the end
                last[1] = Math.max(last[1], current[1]);
            }
        }

        // Convert List<int[]> to int[][]
        return merged.toArray(new int[merged.size()][]);
    }
}