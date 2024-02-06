class MedianFinder:

    def __init__(self):
        self.small, self.large = [], []

    def addNum(self, num: int) -> None:
        heapq.heappush(self.small, -1 * num)
        
        if (self.small and self.large and
            self.small[0] * -1 > self.large[0]):
            val = heapq.heappop(self.small) * -1
            heapq.heappush(self.large, val)
            
        if len(self.small) > len(self.large) + 1:
            val = heapq.heappop(self.small) * -1
            heapq.heappush(self.large, val)
            
        if len(self.small) + 1 < len(self.large):
            val = heapq.heappop(self.large) * -1
            heapq.heappush(self.small, val)

    def findMedian(self) -> float:
        if (len(self.small) + len(self.large)) % 2 == 0:
            return (self.small[0] * -1 + self.large[0]) / 2
        elif len(self.small) > len(self.large):
            return self.small[0] * -1
        else:
            return self.large[0]


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()