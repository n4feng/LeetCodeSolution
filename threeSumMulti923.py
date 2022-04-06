class Solution:
    import math
    def threeSumMulti(self, arr: List[int], target: int) -> int:
        appear = {}
        unique = []
        for i in arr:
            if i in appear:
                appear[i]+=1
            else:
                unique.append(i)
                appear[i]=1
        def nCr(n,r):
            f = math.factorial
            return f(n) // (f(r) * f(n-r))
        def divide2(sortedUniqueArr: List[int], i: int, target: int) -> int:
            if(sortedUniqueArr[i]*2 == target and appear[sortedUniqueArr[i]]>1):
                return nCr(appear[sortedUniqueArr[i]],2)
            else:
                return 0
            
        def twoSum(sortedUniqueArr: List[int], target: int) -> int:
            if(len(sortedUniqueArr) == 1):
                return divide2(sortedUniqueArr, 0,target)
            l,r = 0, len(sortedUniqueArr)-1
            res = 0
            while l <= r:
                if l==r:
                    res+=divide2(sortedUniqueArr, l, target)
                    l+=1
                elif sortedUniqueArr[l]+sortedUniqueArr[r]<target:
                    l+=1
                elif sortedUniqueArr[l]+sortedUniqueArr[r]>target:
                    r-=1
                else:
                    res+=appear[sortedUniqueArr[l]]*appear[sortedUniqueArr[r]]
                    l+=1
                    r-=1

            return res
        res = 0
        unique.sort()
        while len(unique)>0:
            cur = unique[0]
            unique.pop(0)
            if(appear[cur]>2 and cur*3 == target):
                res+=nCr(appear[cur],3)
            elif(appear[cur]>1 and (target-cur*2) in unique):
                res+=nCr(appear[cur],2)*appear[target-cur*2]
            res+=appear[cur]*twoSum(unique, target-cur)
            
        return res
