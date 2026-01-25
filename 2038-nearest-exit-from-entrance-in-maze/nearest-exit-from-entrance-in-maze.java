class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] memo = new int[maze.length][n];
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] directions = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        queue.add(entrance);
        memo[entrance[0]][entrance[1]] = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.removeFirst();
            for (int[] dr : directions) {
                // if inside the maze and not a wall
                int x = dr[0] + current[0];
                int y = dr[1] + current[1];

                if (0 <= x && x < m && 0 <= y && y < n && maze[x][y] != '+' && memo[x][y] == 0 && !(x == entrance[0] && y == entrance[1])) {
                    memo[x][y] = memo[current[0]][current[1]] + 1;

                    // check if this is an entrance
                    if (x == 0 || x == m - 1 || y == 0 || y == n - 1 ) {
                        return memo[x][y];
                    }

                    queue.addLast(new int[] {x, y});
                }
            }
        }

        return -1; 
    }
}