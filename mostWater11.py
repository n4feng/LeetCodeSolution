class Solution:
    def maxArea(self, height: List[int]) -> int:
        maxArea , left, right = 0, 0, len(height)-1
        #if current area is maximum by having max minimum edge
        #there will be no combination within it would be 
        while left < right:
            maxArea = max(maxArea, min(height[left], height[right]) * (right-left))
            if(height[left] < height[right]):
                left+=1
            else:
                right-=1
        
        return maxArea
