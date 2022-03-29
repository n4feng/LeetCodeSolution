class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        rotate = 0
        if len(nums) == 1:
            return nums[0] == target
        for i in range(len(nums)):
            if nums[i] > nums[i+1]:
                rotate = i
                break
            elif i == len(nums)-2:
                rotate = 0
                break
        
        def binarySearch(nums: List[int], target: int) -> bool:
            left, right = 0, len(nums)-1
            while(left <= right):
                pivot = left + (right - left)//2
                if nums[pivot] == target:
                    return True
                elif nums[pivot] < target:
                    left = pivot+1
                else:
                    right = pivot-1
            return False
        
        return binarySearch(nums[:rotate+1], target) or binarySearch(nums[rotate+1:], target)
