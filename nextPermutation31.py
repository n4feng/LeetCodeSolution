class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #scan from right to left to find greatest ith that 
        #all the number on path are in accsending order (right to left)
        #which means all number on the right is the largest permutation of itself
        #(this does not include i, i is tha value need to be swtiched)
        i, iValue = -1, -1
        for k, v in reversed(list(enumerate(nums))):
            if v >= iValue:
                iValue = v
            else:
                iValue = v
                i = k
                break
        
        #if all list is the largest lexicographic permutation, return reversed list
        if i == -1:
            return nums.reverse()
        
        #to find next larger permutation, find the one just be greater than i
        #swap them, and reversed the list on the right of i to make it smallest permutation by itself
        for k, v in reversed(list(enumerate(nums))):
            if v > iValue:
                nums[i], nums[k] = nums[k], nums[i]
                break
        
        #reverse index from i+1 to len(nums)-1
        k = len(nums)-1
        i +=1
        while(k > i):
            nums[i], nums[k] = nums[k], nums[i]
            i+=1
            k-=1
        return nums
                
        
