class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }

        int ROTTEN = 2;
        int EMPTY = 0;
        int freshCount = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        int count = 0;
        // every loop is a count until the queue is empty

        int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // find the rotten fruits
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == ROTTEN) {
                    queue.add(new int[] {r, c});
                }
                if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (queue.isEmpty()) {
            if (freshCount > 0) {
                return -1;
            }
            return 0;
        }

        while (!queue.isEmpty()) {
            // loop over the queue with a set limit
            int size = queue.size();
            for (int curr = 0; curr < size; curr++) {
                int [] current = queue.poll();
                // valid check 
                for (int[] d: dir) {
                    int dr = current[0] + d[0];
                    int dc = current[1]+ d[1];

                    if (0 <= dr && dr < m && 0 <= dc && dc < n && grid[dr][dc] != EMPTY && grid[dr][dc] != ROTTEN) {
                        queue.add(new int[]{dr, dc});
                        grid[dr][dc] = ROTTEN;
                        freshCount--;
                    }
                }
            }
            // only add to count if somethings been added to the queue
            if (!queue.isEmpty()) {
                count++;
            }
        }

        return freshCount == 0 ? count : -1;
    }
}