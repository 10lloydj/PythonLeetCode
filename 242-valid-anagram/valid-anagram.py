class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # create a dictionary of the first world then iterate and reduce the number to 0 and if it goes below 0 return False
        if len(s) != len(t):
            return False
        frequencyMap = dict()

        for x in s:
            if x in frequencyMap:
                frequencyMap[x] = frequencyMap[x] + 1
            else:
                frequencyMap[x] = 1

        for y in t:
            if y in frequencyMap and frequencyMap[y] > 0:
                frequencyMap[y] = frequencyMap[y] - 1
            else:
                return False

        return all(c == 0 for c in frequencyMap.values())
