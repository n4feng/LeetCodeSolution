class Solution {
    public int numIslands(char[][] grid) {
        int raw = grid.length;
        if(raw == 0)
            return 0;
        int column = grid[0].length;
        if(column == 0)
            return 0;
        int islandsNum = 0;
        for(int i = 0; i < raw; i++){
            for(int j = 0; j < column; j++){
                if(grid[i][j] == '1'){
                    islandsNum++;
                    conquer(grid, i, j);
                }
            }
        }
        return islandsNum;
    }
    
    private void conquer(char[][] grid, int poRaw, int poCol){
        //mark the island to 9 as checked
        if(grid[poRaw][poCol] == '1'){
            grid[poRaw][poCol] = '9';
            if(poRaw+1 < grid.length)
                conquer(grid, poRaw+1, poCol);
            if(poRaw-1 >= 0)
                conquer(grid, poRaw-1, poCol);
            if(poCol+1 < grid[poRaw].length)
                conquer(grid, poRaw, poCol+1);
            if(poCol-1 >= 0)
                conquer(grid, poRaw, poCol-1);
        }
                    
    }
}