class DailyTemperatures739 {
    public int[] dailyTemperatures(int[] temperatures) {
        List<Integer> decreaseStack = new ArrayList<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            if(decreaseStack.isEmpty() || temperatures[i] <= temperatures[decreaseStack.get(0)]){
                decreaseStack.add(0, i);
            }
            else{
                while(!decreaseStack.isEmpty() && temperatures[decreaseStack.get(0)] < temperatures[i]){
                    res[decreaseStack.get(0)] = i - decreaseStack.get(0);
                    decreaseStack.remove(0);
                }
                decreaseStack.add(0, i);
            }
        }
        return res;
    }
}
