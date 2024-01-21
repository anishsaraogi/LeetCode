class Solution:
    def maxArea(self, height: List[int]) -> int:
        l, r = 0, len(height) - 1
        maxHeight = 0
        while l < r:
            maxHeight = max(min(height[l], height[r]) * (r - l), maxHeight)
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return maxHeight