class Solution:
    def countSubstrings(self, s: str) -> int:
        ans = 0
        for i in range(len(s)):
            #count odd
            ans += self.countPalindromesAroundCenter(s, i, i)
            
            #count even
            ans += self.countPalindromesAroundCenter(s, i, i+1)
        
        return ans
    
    def countPalindromesAroundCenter(self, s, lo, hi):
        ans = 0
        
        while lo>=0 and hi<len(s):
            if s[lo] != s[hi]:
                break
            
            ans+=1
            lo-=1
            hi+=1
        
        return ans
