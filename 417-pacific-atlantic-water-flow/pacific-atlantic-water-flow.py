class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        m = len(heights)
        n = len(heights[0])

        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        pacific_reachable = [[False] * n for _ in range(m)]
        atlantic_reachable = [[False] * n for _ in range(m)]

        # base recursion
        # only store higher cells in visited and traverse them + neighbours
        def dfs(row, column, visited_reachable):
            if visited_reachable[row][column]:
                return
            visited_reachable[row][column] = True
            for dr, dc in directions:
                current_r = dr + row
                current_c = dc + column
                # check valid range then current is higher than previous
                if 0 <= current_r < m and 0 <= current_c < n and heights[current_r][current_c] >= heights[row][column]:
                    dfs(current_r, current_c, visited_reachable)

        # run on all borders
        for i in range(m):
            dfs(i, 0, pacific_reachable)
        for j in range(n):
            dfs(0, j, pacific_reachable)

        for x in range(m):
            dfs(x, n - 1, atlantic_reachable)
        for y in range(n):
            dfs(m - 1, y, atlantic_reachable)

        return [[i, j] for i in range(m) for j in range(n) if pacific_reachable[i][j] and atlantic_reachable[i][j]]

