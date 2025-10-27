class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        outerLen = len(matrix)
        innerLen = len(matrix[0])

        # find every 0 and store the location

        zeroRow = set()
        zeroColumn = set()

        for x in range(0, len(matrix)):
            for y in range(len(matrix[x])):
                if matrix[x][y] == 0:
                    zeroRow.add(y)
                    zeroColumn.add(x)

        # Iterate over the sets and change every value

        for row in zeroRow:
            for x in range(outerLen):
                matrix[x][row] = 0

        for column in zeroColumn:
            for y in range(innerLen):
                matrix[column][y] = 0
