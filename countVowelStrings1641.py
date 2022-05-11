class Solution:
    def countVowelStrings(self, n: int) -> int:
        return self.calCount(n, 5)
    @lru_cache
    def calCount(self, n: int, pre: int) -> int:
        res = 0
        if n == 0:
            return 1
        for i in range(1, pre+1):
            res+=self.calCount(n-1, i)
        return res
