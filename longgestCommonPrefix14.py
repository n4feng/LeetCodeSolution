class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 0: return ""
        res = strs[0]
        reslength = len(res)
        for s in strs:
            length = min(reslength, len(s))
            
            for i in range(length):
                """print('res is {res} and s is {s} and length is {length} and i is {i}'.format(res=res,s=s,length=reslength, i=i))"""
                if res[i] != s[i]:
                    res = res[:i]
                    reslength = i
                    break
            if reslength == 0: return ""
            if reslength > len(s):
                res = s
                reslength = len(s)
        return res