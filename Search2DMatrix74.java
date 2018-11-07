class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        //binary search will be the most efficient algorithm
        int row = matrix.length;
        int column = matrix[0].length;
        int total = row*column;
        return binarySearchMatrix(matrix, target, column, 1, total);
    }
    public boolean binarySearchMatrix(int[][] matrix, int target, int column, int left, int right){
        //left and right are real index, not array index (array index + 1)
        if(right - left == 1 || right == left){
            if(matrix[(left-1)/column][(left-1)%column] == target || matrix[(right-1)/column][(right-1)%column] == target)
                return true;
            else
                return false;
        }
        
        if(matrix[((right-left)/2+left-1)/column][((right-left)/2+left-1)%column] == target)
            return true;
        else if(matrix[((right-left)/2+left-1)/column][((right-left)/2+left-1)%column] > target)
            return binarySearchMatrix(matrix, target, column, left, right - (right-left)/2);
        else
            return binarySearchMatrix(matrix, target, column, left + (right-left)/2, right);
    }
}