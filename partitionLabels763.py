class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        #create a dictionary to check 
        #each character last appear time in s
        #same as
        #for i,c in enumarte(S):
        #   lastDict[c] = i
        lastDict = {c: i for i,c in enumerate(s)}
        ans = []
        pStart = 0
        curLast = 0
        for i,c in enumerate(s):
            #look at dict, update where should current partition end
            curLast = max(curLast, lastDict[c])
            #if reach to the index where it should end
            if i == curLast:
                #e.g. for s = "ab", first partition size is 0-0+1
                ans.append(i-pStart+1)
                #next partition will start at 'b'
                pStart = i+1
        
        return ans
