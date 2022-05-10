class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        return self.recurSum(k, n, 1, [])
    
    def recurSum(self, k: int, n: int, start: int, path: List[int]) -> List[List[int]]:
        res = []
        for i in range(start, 10):
            if k == 1:
                if i == n:
                    match = []
                    for j in path:
                        match.append(j)
                    match.append(i)
                    res.append(match)
                elif i > n:
                    break
            else:
                if i < n:
                    path.append(i)
                    res += self.recurSum(k-1, n-i, i+1, path)
                    path.pop()
                else:
                    break
        return res
    
