class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        p1 = p2 = 0
        while p1 < len(version1) or p2 < len(version2):
            v1, p1 = self.trimLeadingZero(version1, p1)
            v2, p2 = self.trimLeadingZero(version2, p2)
            if v1 > v2:
                return 1
            elif v1 < v2:
                return -1
        return 0

        return 0
    #function give a start pointer p and version, return 
    #version number at [0] and end index at [1]
    def trimLeadingZero(self, version: str, p: int) ->  List[int]:
        if p >= len(version):
            return 0,p
        start = p
        #trim leading 0
        while p < len(version) and version[p] == '0':
            start+=1
            p+=1
        while p < len(version) and version[p] != '.':
            p+=1
        if start == p:
            return 0,p+1
        return int(version[start:p]), p+1
            
