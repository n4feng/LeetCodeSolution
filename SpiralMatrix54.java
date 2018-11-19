class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int height = matrix.length;
        if(height == 0){
            return new ArrayList<Integer>();
        }
        int width = matrix[0].length;
        if(width == 0)
            return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        
        int r = 0, c = 0, count = 0, state = 0;
        //state: 0 go right, 1 go down, 2 go left, 3 go up
        while(count < height*width){
            //System.out.println("current at row " + r + " column " + c + " and result is "+matrix[r][c]);
            result.add(matrix[r][c]);
            matrix[r][c] = -100;//just a number that indicate this entry has been read, 
			//if it is not accetable, one can create a new array indicate 0 as unread and 1 as read
			//to do the same thing.
            
            if(state == 0){
                if(c == width - 1){
                    state = 1;
                    r++;
                }
                else if(matrix[r][c+1] == -100){
                    state = 1;
                    r++;
                }
                else{
                    c++;
                }
            }
            else if(state == 1){
                if(r == height - 1){
                    state = 2;
                    c--;
                }
                else if(matrix[r+1][c] == -100){
                    state = 2;
                    c--;
                }
                else{
                    r++;
                }
            }
            else if(state == 2){
                if(c == 0){
                    state = 3;
                    r--;
                }
                else if(matrix[r][c-1] == -100){
                    state = 3;
                    r--;
                }
                else{
                    c--;
                }
            }
            else if(state == 3){
                if(r == 0){
                    state = 0;
                    c++;
                }
                else if(matrix[r-1][c] == -100){
                    state = 0;
                    c++;
                }
                else{
                    r--;
                }
            }
            
            count++;
        }
        return result;
        
    }
    
}