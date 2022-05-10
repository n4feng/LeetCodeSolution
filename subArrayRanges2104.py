class Solution:
    def subArrayRanges(self, nums: List[int]) -> int:
        n = len(nums)
        
        min_stack = []
        min_sum = 0

        for i in range(n + 1):
            while min_stack and nums[min_stack[-1]] > (nums[i] if i < n else -float('Inf')):
                j = min_stack.pop()
                k = min_stack[-1] if min_stack else -1
                min_sum += (j - k) * (i - j) * nums[j]
            min_stack.append(i)
        
        max_stack = []
        max_sum = 0
        for i in range(n + 1):
            #find the largest range (k, i) that nums[j] is smallest in this range
            #the number of subarraies include j could form by this range would be:
            #on the left side, you have j-k choice [(k+1,k+2,...,j),(k+2,...,j),...,j]
            #on the right side, you have i=j choice [(j,...,i-2, i-1), (j,...,i-2), ..., j]
            #you can perform combination by choose 1 from left side and 1 from right side
            #so total number of subarries is (j-k)*(i-j)
            while max_stack and nums[max_stack[-1]] < (nums[i] if i < n else float('Inf')):
                j = max_stack.pop()
                k = max_stack[-1] if max_stack else -1
                max_sum += (j - k) * (i - j) * nums[j]

            max_stack.append(i)
        
        ans = max_sum - min_sum
        
        return ans
