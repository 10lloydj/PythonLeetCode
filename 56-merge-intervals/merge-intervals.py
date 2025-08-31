class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) == 0:
            return []
        if len(intervals) == 1:
            return intervals

        intervals.sort(key=lambda x: x[0])
        merged = [intervals[0]]
        # since its sorted, I know the start can never be less than the previous so I need to focus on the last values in comparisons
        for x in range(1, len(intervals)):
            last = merged[-1]
            current = intervals[x]
            if current[0] > last[1]:
                merged.append(current)
                continue
            if current[1] <= last[1]:
                continue
            if current[0] <= last[1]:
                # edit last to have a new end
                merged[-1][1] = max(merged[-1][1], current[1])
                continue
            merged.append(current)
        return merged