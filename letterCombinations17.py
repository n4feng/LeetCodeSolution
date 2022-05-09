class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return []
        return self.letterCombRecur(digits, "")
    
    def letterCombRecur(self, digits: str, prefix: str) -> List[str]:
        if len(digits) == 0:
            return [prefix]
        res = []
        if int(digits[0]) == 7:
            for i in range(4):
                temp = prefix + chr(ord('p')+i)
                res+=self.letterCombRecur(digits[1:], temp)
        elif int(digits[0]) == 8:
            for i in range(3):
                temp = prefix + chr(ord('t')+i)
                res+=self.letterCombRecur(digits[1:], temp)
        elif int(digits[0]) == 9:
            for i in range(4):
                temp = prefix + chr(ord('w')+i)
                res+=self.letterCombRecur(digits[1:], temp)
        else:
            for i in range(3):
                c = chr(ord('a')+(int(digits[0])-2)*3+i)
                temp = prefix + c
                res+=self.letterCombRecur(digits[1:], temp)
        return res
