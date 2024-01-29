class Solution:
    def search(self, nums: List[int], target: int) -> int:
        res = nums[0]
        pos = 0
        l, r = 0, len(nums) - 1
        while l <= r:
            if nums[l] < nums[r]:
                if nums[l] < res:
                    res = nums[l]
                    pos = l
                break
                
            m = (l + r) // 2
            if nums[m]< res:
                res = nums[m]
                pos = m
            if nums[l] <= nums[m]:
                l = m + 1
            else:
                r = m - 1
        rot = len(nums) - pos
        if len(nums) == rot: rot = 0
        new_list = nums[pos:len(nums)] + nums[0:pos]
        ans = -1
        l, r = 0, len(new_list) - 1
        while l <= r:
            m = (l + r) // 2
            if new_list[m] == target:
                ans = m
                break
            if new_list[m] < target:
                l = m + 1
            else:
                r = m - 1
        if ans == -1:
            return -1
        else:
            return (ans - rot) if (ans - rot) >= 0 else ans - rot + len(nums)