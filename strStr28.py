class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        nextArray = self.buildNextArray(needle)
        needleIndex = 0
        i = 0
        while i < len(haystack):
            while(needleIndex > 0 and needle[needleIndex] != haystack[i]):
                needleIndex = nextArray[needleIndex-1]
            if haystack[i] == needle[needleIndex]:
                needleIndex+=1
            if needleIndex == len(needle):
                return i-needleIndex+1
            i+=1
        return -1
        
    def buildNextArray(self, needle):
        res = [0]
        curLen = 0
        for i in range(len(needle)-1):
            while curLen > 0 and needle[curLen] != needle[i+1]:
                curLen = res[curLen-1]
            #check in case 0 also not equal to needle
            if needle[curLen] == needle[i+1]:
                curLen+=1
            res.append(curLen)
        return res
