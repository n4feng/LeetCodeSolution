class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0)
            return null;
        int[][] result = new int[n][n];
        int value = 1;
        for(int i = 1; i <= n/2; i++){
            //(2i)^2 - (2i-2)^2 = 8i - 4
            for(int j = 1; j <= 4*n - 8*i + 4; j++){
                if(j <= n - 2*(i - 1)){
                    //1,2,3
                    //1,2,3,4
                    //System.out.println("value " + value + " is recorded in 1");
                    result[i-1][j-1 + i-1] = value;
                }
                else if(j > n - 2*(i - 1) && j <= 2*n - 4*i + 2){
                    //4
                    //5,6
                    //System.out.println("value " + value + " is recorded in 2");
                    result[j - (n - 2*(i - 1)) + i-1][n-i] = value;
                }
                else if(j > 2*n - 4*i + 2 && j <= 3*n - 6*i + 4){
                    //5,6,7
                    //7,8,9,10
                    //System.out.println("value " + value + " is recorded in 3");
                    //System.out.println("j is " + j + " n is " + n + " i is " + i);
                    result[n-i][n-i-(j - (2*n - 4*i + 2) - 1)] = value;
                }
                else{
                    //8
                    //11,12
                    //System.out.println("value " + value + " is recorded in 4");
                    result[n-i-(j-(3*n - 6*i + 4))][i-1] = value;
                }
                value++;
            }            
        }
        if(n%2 == 1){
            result[n/2][n/2] = value;
        }
        return result;
    }    
}
