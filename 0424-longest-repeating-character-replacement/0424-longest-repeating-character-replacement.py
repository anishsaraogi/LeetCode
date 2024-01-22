class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        charCount = defaultdict(int)
        l = 0
        maxF = 0
        res = 0
        for r in range(len(s)):
            charCount[s[r]] += 1
            maxF = max(maxF, charCount[s[r]])
            if r - l + 1 - maxF <= k:
                res = max(r - l + 1, res)
            else:
                charCount[s[l]] -= 1
                l += 1
        return res