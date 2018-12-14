class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        else if(nums.length == 1) return nums[0];
        int[] mostValue = new int[nums.length];
        mostValue[0] = nums[0];
        mostValue[1] = Math.max(nums[0], nums[1]);
        if(nums.length == 2) return mostValue[1];
        for(int i = 2; i < nums.length; i++){
            mostValue[i] = Math.max(mostValue[i-2]+nums[i],mostValue[i-1]);
        }
        return mostValue[nums.length-1];
    }
}