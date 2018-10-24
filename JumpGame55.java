class Solution {
    //DFS solution, looks like they don't like brute-force so they made a test case to prvent it
    /*public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return true;
        return jumpTo(nums,0);
    }
    private boolean jumpTo(int[] nums, int currentPos){
        boolean getEnd = false;
        if(currentPos == nums.length -1)
            return true;
        else{
            for(int i = 1; i <= nums[currentPos]; i++){
                if(jumpTo(nums,currentPos+i)){
                    getEnd = true;
                    break;
                }                                
            }
            return getEnd;
        }
    }*/
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return true;
        for(int i = 0; i < nums.length; i++){
            if(i == nums.length -1)
                return true;
            else if(nums[i] == 0){
                boolean canCross = false;
                if(i < nums.length - 1){
                    for(int j = 0; j < i; j++){
                        if(nums[i-1-j] > j+1 || 
                           nums[i-1-j] >= nums.length - i + j){
                            //System.out.println("can cross position " + i + " from position " + (i-1-j));
                            canCross = true;
                            break;
                        }
                    }
                    if(!canCross){
                        System.out.println("can't cross position " + i);
                        return false;
                    }                        
                }
                else{
                    for(int j = 0; j < i; j++){
                        //for the last one, you only need to reach the position
                        if(nums[i-1-j] >= j+1 || 
                           nums[i-1-j] >= nums.length - i + j){
                            //System.out.println("can cross position " + i + " from position " + (i-1-j));
                            canCross = true;
                            break;
                        }
                    }
                    if(!canCross){
                        System.out.println("can't cross position " + i);
                        return false;
                    }             
                }
            }
        }
        return true;
    }
}