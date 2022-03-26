class Solution:
    def getSmallestString(self, n: int, k: int) -> str:
        #fill up with all a
        #that will take n 1s from k
        #fill backward, make everything 'z' when remain > 25
        remain = k-n
        res = ""
        while remain > 0:
            n-=1
            if remain <= 25:
                c = chr(ord('a')+remain)
                res=c+res
                remain=0
                for i in range(n):
                    res='a'+res
            else:
                res='z'+res
                remain-=25
        return res
