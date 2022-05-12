class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        return self.backTracePermute(nums, [])
        
    def backTracePermute(self, unUsed: List[int], used: List[int]) -> List[List[int]]:
        res = []
        if len(unUsed) == 0:
            return [copy.deepcopy(used)]
        else:
            used.append(unUsed.pop(0))
            res+=self.backTracePermute(unUsed, used)
            unUsed.insert(0, used.pop())
            if len(unUsed) > 1:
                for i in range(1, len(unUsed)):
                    if unUsed[i] != unUsed[i-1]:
                        used.append(unUsed.pop(i))
                        res+=self.backTracePermute(unUsed, used)
                        unUsed.insert(i, used.pop())
            return res
