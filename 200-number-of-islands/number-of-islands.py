class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        m = len(grid)
        n = len(grid[0])
        visited = set()
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        count = 0

        def find_island(row, column):
            q = deque()
            visited.add((row, column))
            q.append((row, column))
            while q:
                row, column = q.popleft()
                for dr, dc in directions:
                    r, c = row + dr, column + dc
                    if (r in range(m) and c in range(n) and grid[r][c] == '1' and (r, c) not in visited):
                        q.append((r, c))
                        visited.add((r, c))

        for row in range(m):
            for column in range(n):
                if grid[row][column] == '1' and (row, column) not in visited:
                    find_island(row, column)
                    count += 1
        return count