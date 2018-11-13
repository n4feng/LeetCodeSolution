class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if(nums.length == 1)
            return nums[0];
        while(end - start > 1){
            int mid = start + (end - start) / 2;
            if(nums[start] > nums[mid]){ //no duplicate
                end = mid;
            }
            else if(nums[mid] > nums[end])
                start = mid;
            else
                return nums[start];//no rotation
        }
        if(nums[start] > nums[end])
            return nums[end];
        else
            return nums[start];
    }
}