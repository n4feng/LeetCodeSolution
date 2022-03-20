class FreqStack895 {
    int maxFreq;
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    public FreqStack() {
        maxFreq = 0;
        freq = new HashMap<>();
        group = new HashMap<>();
    }
    
    public void push(int val) {
        int newFreq = freq.getOrDefault(val, 0)+1;
        freq.put(val, newFreq);
        group.computeIfAbsent(newFreq, v->new Stack()).push(val);
        if(newFreq > maxFreq)
            maxFreq = newFreq;
    }
    
    public int pop() {
        Stack<Integer> maxStack = group.get(maxFreq);
        int popVal = maxStack.pop();
        freq.put(popVal, freq.get(popVal)-1);
        //since we only populated 1 elements
        //if nothing left in top group
        //in next round the greatest value should always have
        //the preMax-1 frequency
        
        /*e.g.
        originally:
        push: 5,7,5,7,4,5
            group:{
            3: 5
            2: 5,7
            1: 5,7, 4
            }
        pop() ->5 in freq 3 group being poped
            group:{
            2: 5,7
            1: 5,7, 4
            }
        */
        if(maxStack.size() == 0)
            maxFreq-=1;
        
        return popVal;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
