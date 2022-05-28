class MissingNumber268 {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int a = nums[i] >= 0 ? nums[i] : Math.abs(nums[i])-1;
            if(a < nums.length && nums[a] >= 0){
                nums[a] = -nums[a] - 1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > -1){
                return i;
            }
        }
        return nums.length;
    }
}
