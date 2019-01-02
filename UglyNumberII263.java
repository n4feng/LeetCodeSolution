class Solution {
    public int nthUglyNumber(int n) {
        //since the return is int, I just assume 1690th ugly number is still an int
        //use a list to store all founded ugly number so each access is an On operation
        if(n == 0) return 0;
        List<Integer> uglys = new ArrayList<>();
        uglys.add(1);
        int L2 = 0;
        int L3 = 0;
        int L5 = 0;
        int nextUgly = 1;
        for(int i = 1; i < n; i++){
       
            if(uglys.get(L2)*2 < uglys.get(L3)*3 && uglys.get(L2)*2 < uglys.get(L5)*5){
                nextUgly = uglys.get(L2)*2;
                L2++;
            } 
            else if(uglys.get(L2)*2 == uglys.get(L3)*3 && uglys.get(L2)*2 < uglys.get(L5)*5){
                nextUgly = uglys.get(L2)*2;
                L2++;
                L3++;
            }
            else if(uglys.get(L2)*2 == uglys.get(L5)*5 && uglys.get(L2)*2 < uglys.get(L3)*3){
                nextUgly = uglys.get(L2)*2;
                L2++;
                L5++;
            }
            else if(uglys.get(L3)*3 < uglys.get(L2)*2 && uglys.get(L3)*3 < uglys.get(L5)*5){
                nextUgly = uglys.get(L3)*3;
                L3++;              
            } 
            else if(uglys.get(L3)*3 == uglys.get(L5)*5 && uglys.get(L3)*3 < uglys.get(L2)*2) {
                nextUgly = uglys.get(L3)*3;
                L3++;
                L5++;
            }
            else if(uglys.get(L5)*5 < uglys.get(L3)*3 && uglys.get(L5)*5 < uglys.get(L3)*3){
                nextUgly = uglys.get(L5)*5;
                L5++;
            } 
            else if(uglys.get(L2)*2 == uglys.get(L3)*3 && uglys.get(L2)*2 == uglys.get(L5)*5){
                nextUgly = uglys.get(L5)*5;
                L2++;
                L3++;
                L5++;
            }
            uglys.add(nextUgly);
        }
        for(int i = 0; i < uglys.size(); i++){
            System.out.print(uglys.get(i)+" ");
        }
        return nextUgly;
    }
}