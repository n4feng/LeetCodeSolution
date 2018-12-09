class Solution:
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        s = s.strip()
        
        if len(s) == 0: return 0
        for i in range(len(s) - 1):
            if s[len(s) - 1 - i] == ' ': return i
        return len(s)