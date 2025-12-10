class Solution:
    def countSubstrings(self, s: str) -> int:
        count = 0

        def expand(left, right):
            local_count = 0
            while left >= 0 and right < len(s) and s[left] == s[right]:
                local_count += 1
                left -= 1
                right += 1
            return local_count

        for centre in range(len(s)):
            even_pal = expand(centre, centre + 1)
            odd_pal = expand(centre, centre)
            count = count + even_pal + odd_pal
        
        return count