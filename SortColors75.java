class Solution {
    public void sortColors(int[] nums) {
        int [] rgb = new int[3];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                rgb[0]++;
            else if(nums[i] == 1)
                rgb[1]++;
            else
                rgb[2]++;
            
        }
        int count = 0;
        for(int i = 0; i < rgb[0]; i++){
            nums[count] = 0;
            count++;
        }

        for(int i = 0; i < rgb[1]; i++){
            nums[count] = 1;
            count++;
        }
            
        for(int i = 0; i < rgb[2]; i++){
            nums[count] = 2;
            count++;
        }
        
    }
}