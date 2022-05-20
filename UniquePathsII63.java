class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 1 && obstacleGrid[0].length == 1){
            if(obstacleGrid[0][0] == 0) return 1;
            else return 0;
        }
        else if(obstacleGrid[0][0] == 1) return 0;
        int[][] memory = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < memory.length; i++){
            Arrays.fill(memory[i] , -1);
        }
        calPath(obstacleGrid, memory, 0, 0);
        return memory[0][0];
    }
    public void calPath(int[][] grid, int[][] memory, int row, int col){
        int path = 0;
        if(row+1 < grid.length && grid[row+1][col] != 1){
            if(row+1 == grid.length - 1 && col == grid[0].length-1){
                path+=1;
            }
            else if(memory[row+1][col] > -1){
                path+= memory[row+1][col];
            }
            else{
                calPath(grid, memory, row+1, col);
                path+= memory[row+1][col];
            }
        }
        if(col+1 < grid[0].length && grid[row][col+1] != 1){
            if(row == grid.length - 1 && col + 1 == grid[0].length-1){
                path+=1;
            }
            else if(memory[row][col+1] > -1){
                path+= memory[row][col+1];
            }
            else{
                calPath(grid, memory, row, col+1);
                path+= memory[row][col+1];
            }
        }
        memory[row][col] = path;
    }
}
