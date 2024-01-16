class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        str1 = defaultdict(int)
        str2 = defaultdict(int)
        for a in s:
            str1[a] += 1
        for b in t:
            str2[b] += 1
        if str1 == str2:
            return True
        return False