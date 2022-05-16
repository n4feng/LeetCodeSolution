class FirstMissingPositive41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //change all numbers greater than size or smaller than 0 to 1
        //as we don't care about them in result
        boolean is1exist = false;
        for(int i = 0; i < n; i++){
            //since we are mocking unwanted value with 1's
            //we need to manually detect if 1 exist in original list
            if(nums[i] == 1) is1exist = true;
            if(nums[i] < 1 || nums[i] > n){
                nums[i] = 1;
            }
        }
        
        //return 1 if 1 does not exist
        if(!is1exist) return 1;
        
        //now mark entry value to negative value if they appeared in our list
        //since they maybe negative, so when evaluate call abs() to get it's original value
        for(int i = 0; i < n; i++){
            int val = Math.abs(nums[i]) - 1;
            if(val != 0 && nums[val] > 0){
                nums[val] = -nums[val];
            }
        }
        //from 2nd element, find the first element that is not negative,
        //that means it is the first positive value not in the list
        for(int i = 1; i < n; i++){
            if(nums[i] > 0) return i+1;
        }
        //if all find, return n+1
        return n+1;
    }
}
