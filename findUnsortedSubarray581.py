class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        if len(nums) < 2: 
            return 0
        unSortedMin, unSortedMax = pow(10,5)+1, -pow(10,5)-1
        unsorted = False
        for i in range(1, len(nums)):
            if nums[i-1] > nums[i]:
                unsorted = True
                unSortedMax = max(unSortedMax, nums[i-1])
        for i in range(len(nums)-1, 0, -1):
            if nums[i-1] > nums[i]:
                unSortedMin = min(unSortedMin, nums[i])

        if not unsorted:
            return 0
        left, right = 0, len(nums)-1
        while(left < len(nums)-1):
            if nums[left] > unSortedMin:
                break
            left += 1
        while(right > 1):
            if nums[right] < unSortedMax:
                break
            right -= 1        
        return right - left + 1

            
        
