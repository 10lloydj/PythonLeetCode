class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])
        merged = [intervals[0]]
        # since its sorted, I know the start can never be less than the previous so I need to focus on the last values in comparisons
        for x in range(1, len(intervals)):
            last = merged[-1]
            current = intervals[x]
            if current[0] > last[1]:
                merged.append(current)
                continue
            else:
                # edit last to have a new end
                merged[-1][1] = max(merged[-1][1], current[1])
                continue
        return merged