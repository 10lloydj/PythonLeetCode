class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        group = {}
        for current in strs:
            current_char = list(current)
            sorted_char = sorted(current_char)
            sorted_string = ''.join(sorted_char)
            if sorted_string in group:
                group[sorted_string].append(current)
            else:
                group[sorted_string] = [current]

        result = []
        for value in group.values():
            result.append(value)

        return result
