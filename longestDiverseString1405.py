class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        res = ""
        abc = [a,b,c]
        while a>0 or b>0 or c>0:
            append = self.chooseithLargest(abc[0],abc[1],abc[2],2)
            if append == 'a':
                if abc[1] == 0 and abc[2] == 0:
                    res += min(2, abc[0])*"a"
                    break
            elif append == 'b':
                if abc[0] == 0 and abc[2] == 0:
                    res += min(2, abc[1])*"b"
                    break
            else:
                if abc[0] == 0 and abc[1] == 0:
                    res += min(2, abc[2])*"c"
                    break
            resLen = len(res)
            if resLen < 2 or not(res[resLen-1] == append and res[resLen-2] == append):
                res += append
                abc[ord(append)-ord('a')] -= 1
            else:
                append = self.chooseithLargest(abc[0],abc[1],abc[2],1)
                res += append
                abc[ord(append)-ord('a')] -= 1
        return res
    def chooseithLargest(self, a: int, b: int, c: int, i:int):
        abc = {'a': a, 'b': b, 'c': c}
        sorted_abc = sorted(abc, key=abc.get)
        return sorted_abc[i]
        
