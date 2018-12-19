class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length&&nums[i] <= 0; i++){
            
            Set<Integer> exist = new HashSet<>();
            for(int j = i+1; j < nums.length; j++){
                if(exist.contains(0-nums[i]-nums[j])){
                    exist.add(nums[j]);
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(0-nums[i]-nums[j]);
                    l.add(nums[j]);
                    res.add(l);
                    while(j<nums.length-1){//to keep results unique
                        if(nums[j+1] == nums[j])j++;
                        else break;
                    }   
                }
                else{
                    exist.add(nums[j]);
                }
            }
            while(i<nums.length-1){//to keep results unique
                if(nums[i+1] == nums[i])i++;
                else break;
            }    
        }
        return res;
    }
}