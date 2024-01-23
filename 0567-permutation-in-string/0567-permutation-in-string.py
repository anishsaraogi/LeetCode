class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s2) < len(s1): return False
        l, r = 0, len(s1)
        str1, str2 = [0] * 26, [0] * 26
        for i in range(len(s1)):
            str1[ord(s1[i]) - ord("a")] += 1
            str2[ord(s2[i]) - ord("a")] += 1
        while r < len(s2):
            if str1 == str2: return True
            str2[ord(s2[l]) - ord("a")] -= 1
            str2[ord(s2[r]) - ord("a")] += 1
            l += 1
            r += 1
        return str1 == str2