import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> appeared = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            
            if(appeared.containsKey(target-nums[i])){
                result[0] = appeared.get(target-nums[i]);
                result[1] = i;
                break;
            }
            if(!appeared.containsKey(nums[i]))
                appeared.put(nums[i],i);
        }
        return result;
    }
}