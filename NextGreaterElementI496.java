class NextGreaterElementI496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Pos = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            nums1Pos.put(nums1[i], i);
        }
        
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        //Monotone Stack
        List<Integer> decreaseStack = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++){
            while(!decreaseStack.isEmpty() && nums2[i] > decreaseStack.get(0)){
                res[nums1Pos.get(decreaseStack.get(0))] = nums2[i];
                decreaseStack.remove(0);
            }
            
            if(nums1Pos.containsKey(nums2[i])){
                decreaseStack.add(0, nums2[i]);
            }
        }
        return res;
    }
}
