class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)
        c = 0
        m = 0
        for n in nums:
            if n-1 in numSet:
                continue
            d = n
            c = 0
            while d in numSet:
                c += 1
                d += 1
            m = max(m,c)
        return m