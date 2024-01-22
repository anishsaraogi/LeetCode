class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0 or len(s) == 1: return len(s)
        l, r = 0, 1
        maxS = 0
        while r < len(s):
            if s[r] in s[l:r]:
                maxS = max(maxS, r-l)
                while s[r] in s[l:r]:
                    l += 1
            else:
                if r == len(s) - 1:
                    maxS = max(maxS, r - l + 1)
            r += 1
        return maxS