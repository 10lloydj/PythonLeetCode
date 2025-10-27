class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # (2 x 3) == 2 rows, 3 columns
        # loop over matrix - I dont need to visit every item as I'm setting rows + columns to zero. So if I find a 0, make the changes and skip the row and mark column visited vice versa

        # problem with this thought is that i will miss values that are already zero

        # maybe iterate over a row, and collect all position that are zero and only change previously visited
        outerLen = len(matrix)
        innerLen = len(matrix[0])

        # find every 0 and store the location
        visited = set()
        isZero = set()
        for x in range(0, len(matrix)):
            for y in range(len(matrix[x])):
                if matrix[x][y] == 0:
                    isZero.add((x, y))

        # Iterate over the set and change every value

        for current in isZero:
            # current has an x, y
            for x in range(0, outerLen):
                checkx = matrix[x][current[1]]
                coordx = (x, current[1])
                if checkx != 0 and (coordx not in visited or coordx not in isZero):
                    matrix[x][current[1]] = 0
                    visited.add(coordx)
            
            for y in range(0, innerLen):
                checky = matrix[current[0]][y]
                coordy = (current[0], y)

                if checky != 0 and (coordy not in visited or coordy not in isZero):
                    matrix[current[0]][y] = 0
                    visited.add(coordy)
