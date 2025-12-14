class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        # [m][n]
        rows = len(matrix)
        columns = len(matrix[0])

        up = 0
        left = 0
        right = columns - 1
        down = rows - 1
            
        output = []
        
        def hor_sim(right: bool, start, end, row, output):
            if right:
                for x in range(start, end):
                    output.append(matrix[row][x])
            else:
                for x in range(start, end, -1):
                    output.append(matrix[row][x])

        def ver_sim(down: bool, start, end, col, output):
            if down:
                for y in range(start, end):
                    output.append(matrix[y][col])
            else:
                for y in range(start, end, -1):
                    output.append(matrix[y][col])
        
        while len(output) < rows * columns:
            # left to right
            hor_sim(True, left, right + 1, up, output)
            # down
            ver_sim(True, up + 1, down + 1, right, output)

            # right to left
            if up != down:
                hor_sim(False, right - 1, left - 1, down, output)
            # up
            if left != right:
                ver_sim(False, down - 1, up, left, output)

            # move all boundaries inwards
            left += 1
            right -= 1
            up += 1
            down -= 1

        return output