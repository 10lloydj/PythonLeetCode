class Solution {
    public int uniquePaths(int m, int n) {
        // m == rows
        // n == cols
        if (m == 1) {
            return 1;
        }
        int rows = m;
        int cols = n;

        int[][] dp = new int[rows][cols];

        // populate edges / base cases where the edges only have 1 path

        for (int r = 0; r < rows; r++) {
            dp[r][cols - 1] = 1;
        }

        for (int c = 0; c < cols; c++) {
            dp[rows - 1][c] = 1;
        }

        for (int x = rows - 2; x >= 0; x--) {
            for (int y = cols - 2; y >= 0; y--) {
                //  dp == 2 below
                dp[x][y] = dp[x + 1][y] + dp[x][y + 1];
            }
        }

        return dp[0][0];
    }
}