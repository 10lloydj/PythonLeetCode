class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # transpose
        for x in range(len(matrix)):
            for y in range(x, len(matrix)):
                matrix[x][y], matrix[y][x] = matrix[y][x], matrix[x][y]

        # reverse
        for row in matrix:
            left, right = 0, len(row) - 1
            while left < right:
                row[left], row[right] = row[right], row[left]
                left += 1
                right -= 1
                
