class SubsetsII90 {
    //backtrace method
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        res = new ArrayList<>();
        backtrace(path, 0, nums);
        return res;
    }
    private void backtrace(List<Integer> path, int start, int[] nums){
        res.add(new ArrayList(path));
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrace(path, i+1, nums);
            path.remove(path.size()-1);
            //skip all elements that is equal to current one
            while(i+1 < nums.length && nums[i+1] == nums[i])
                i++;
        }
    }
}

class SubsetIIDFS {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        dFSearch(result, 0, nums, new ArrayList<>());
        return result;
        
    }
    private void dFSearch(List<List<Integer>> result, int depth, int[] nums, List<Integer> stream){
        //don't add current item on the left branch, add item on the right branch
        if(depth == nums.length)
            result.add(new ArrayList<>(stream));
        else{
            //System.out.println("at depth "+depth);
            if(stream.isEmpty() || stream.get(stream.size() - 1) != nums[depth]){
                //left, the left node will be discard
                //when there is a same stream in the same depth on its left 
                //which is the right node of its common ancester's chid
                
                //              CA       
                //           /      \              2
                //          CA      CA,2             
                //         /  \      / \           2
                //        CA |CA,2| X   CA,2,2
                //       /  \ / \   X   /  \
                //      ......................
                dFSearch(result, depth+1,nums,stream);
            }
            stream.add(nums[depth]);
            //right
            dFSearch(result, depth+1, nums,stream);
            //clean up since we are using the same stream
            stream.remove(stream.size()-1);
        }
    }
}
