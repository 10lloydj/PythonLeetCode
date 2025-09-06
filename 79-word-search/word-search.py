class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        firsts = [
            (r, c)
            for r, row in enumerate(board)
            for c, ch in enumerate(row)
            if ch == word[0]
        ]
        if not firsts:
            return False

        # ensures all checks are valid options
        ROWS, COLS = len(board), len(board[0])
        DIRS = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        def findNext(idx: int, r: int, c: int, visited: set[tuple[int, int]]) -> bool:
            if idx == len(word) - 1:
                return True  # matched the last character

            for dr, dc in DIRS:
                nr, nc = r + dr, c + dc
                if (
                    0 <= nr < ROWS and
                    0 <= nc < COLS and
                    (nr, nc) not in visited and
                    board[nr][nc] == word[idx + 1]
                ):
                    visited.add((nr, nc))
                    if findNext(idx + 1, nr, nc, visited):
                        return True
                    visited.remove((nr, nc))
            return False

        return any(
            findNext(0, r, c, {(r, c)})
            for r, c in firsts
        )
