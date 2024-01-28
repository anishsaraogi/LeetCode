class Solution:
    def minWindow(self, s: str, t: str) -> str:
        sc, tc = defaultdict(int), defaultdict(int)
        for v in t:
            tc[v] += 1
        need = len(tc)
        have = 0
        res = ""
        reslen = float("infinity")
        i, j = 0, 0
        while j < len(s):
            sc[s[j]] += 1
            if s[j] in tc and sc[s[j]] == tc[s[j]]:
                have += 1
            j += 1
            while have == need:
                if (j - i) < reslen:
                    reslen = j - i
                    res = s[i:j]
                sc[s[i]] -= 1
                if s[i] in tc and sc[s[i]] < tc[s[i]]:
                    have -= 1
                i += 1
        return res