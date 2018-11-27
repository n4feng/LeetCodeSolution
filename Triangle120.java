class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);
        int [] preSum = new int[triangle.size()];
        int [] curSum = new int[triangle.size()];
        
        preSum[0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++){
            int curMin = Integer.MAX_VALUE;
            for(int j = 0; j < triangle.get(i).size(); j++){
                curSum[j] = triangle.get(i).get(j) + preMin(i,j,triangle, preSum);
                //System.out.print("curSum "+ j +" is "+ curSum[j] + ", ");
                if(curMin > curSum[j])
                    curMin = curSum[j];
            }
            if(i == triangle.size()-1)
                return curMin;
            //System.out.println("current min is " + curMin);
            preSum = curSum;
            curSum = new int[triangle.size()];
        }
        return -1;
    }
    
    private int preMin(int row, int column, List<List<Integer>> triangle, int [] preSum){
        if(column == 0) return preSum[0];
        else if(column == triangle.get(row).size()-1) return preSum[column-1];
        else return Math.min(preSum[column-1],preSum[column]);
    }
}