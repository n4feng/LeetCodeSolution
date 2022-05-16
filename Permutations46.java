class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)
            return null;
        List<Integer> unfixed = new ArrayList<Integer>();
        for (int i : nums){
            unfixed.add(i);
        }
        List<Integer> fixed = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        fixThem(fixed, unfixed,result);
        return result;
    }
    
    public void fixThem(List<Integer> fixed, List<Integer> unfixed, List<List<Integer>> result){
        if(unfixed.size() == 0)
            result.add(fixed);
        else{
            for(int i = 0; i < unfixed.size(); i++){
                List<Integer> fixedNew = new ArrayList<Integer>();
                for(int j:fixed){
                    fixedNew.add(j);
                }
                fixedNew.add(unfixed.get(i));
                List<Integer> unfixedNew = new ArrayList<Integer>();
                for(int j:unfixed){
                    unfixedNew.add(j);
                }
                unfixedNew.remove(i);
                fixThem(fixedNew,unfixedNew,result);
            }
        }
    }
}
