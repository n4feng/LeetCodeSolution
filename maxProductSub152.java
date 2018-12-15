class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp = max;
            max = Math.max(nums[i],Math.max(max*nums[i],min*nums[i]));
            //this min is only temporarily tracking current max trend when meeting a negative number
            //It checks all possible combination may cause get a min number
            min = Math.min(nums[i],Math.min(temp*nums[i],min*nums[i]));
            result = result>max?result:max;
        }
        return result;
        
    }
}