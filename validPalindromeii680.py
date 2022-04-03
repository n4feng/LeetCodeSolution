class Solution:
    def validPalindrome(self, s: str) -> bool:
        def chedckPalindrome(s: str, left: int, right: int) -> bool:
            while left < right:
                if s[left] == s[right]:
                    left+=1
                    right-=1
                else:
                    return False

            return True
        
        left, right = 0, len(s)-1
        while left < right:
            if s[left] == s[right]:
                left+=1
                right-=1
            else:
                return chedckPalindrome(s, left+1, right) or chedckPalindrome(s, left, right-1)
        return True
