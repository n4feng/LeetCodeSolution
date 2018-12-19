class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0, nums.length-1);
        return nums[nums.length - k];
    }
    
    public void quickSort(int[] nums, int low, int high){
        if(low < high){
            //pivot = high
            int piPos = low-1;
            for(int i = low; i < high; i++){//don't deal with high in the loop
                if(nums[i] < nums[high]){
                    piPos++;
                    swap(nums, piPos, i);
                }                
            }
            swap(nums, piPos+1, high);    
            quickSort(nums,low,piPos);
            quickSort(nums,piPos+2,high);            
        }                
    }
    
    public void swap(int[] nums, int iFirst, int iSecond){
        
        int temp = nums[iFirst];
        nums[iFirst] = nums[iSecond];
        nums[iSecond] = temp;
    }
}