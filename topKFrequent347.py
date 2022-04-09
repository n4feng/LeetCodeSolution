class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        uniqueCount = {}
        for i in nums:
            if i in uniqueCount:
                c = uniqueCount[i]+1
                uniqueCount[i] = c
            else:
                uniqueCount[i] = 1
        res = []
        for key, value in uniqueCount.items():
            bisect.insort(res, key, key=lambda k:-uniqueCount[k])
            if len(res) > k:
                res.pop()
        
        return res
                    
