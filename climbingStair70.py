class Solution:
        
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1: return 1
        elif n == 2: return 2
        step = [1,1]
        for i in range(n - 1):
            step.append(step[i] + step[i+1])
        return step[-1]
        