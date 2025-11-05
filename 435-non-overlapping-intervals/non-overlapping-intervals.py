class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        if len(intervals) == 0:
            return 0
        count = 0

        intervals.sort(key= lambda x: x[1])

        end = intervals[0][1]

        for current in range(1, len(intervals)):
            if intervals[current][0] < end:
                # overlap ( [a,b], [c,d]. overlap if c < b when sorted by end values)
                count = count + 1
            else:
                end = intervals[current][1]

        return count
