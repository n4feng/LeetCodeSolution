class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []
        for c in s:
            if len(stack) == 0 or stack[len(stack)-1][0] != c:
                stack.append([c,1])
            else:
                if stack[len(stack)-1][1] == k-1:
                    stack.pop()
                else:
                    stack[len(stack)-1][1]+=1
        res = ""
        for i in stack:
            for j in range(i[1]):
                res+=i[0]
        return res
