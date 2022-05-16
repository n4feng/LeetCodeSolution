class ShortestPathBinaryMatrix1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = -1;
                }
            }
        }
        //q[0] is row#, q[1] is col#, q[2] is previous Step
        List<int[]> queue = new ArrayList<>();
        int[] start = {0,0,0};
        queue.add(start);
        while(!queue.isEmpty()){
            int[] cur = queue.remove(0);
            if(grid[cur[0]][cur[1]] == -1) continue;
            
            if(cur[0] == grid.length - 1 && cur[1] == grid[0].length-1)
                return cur[2]+1;
            else if(grid[cur[0]][cur[1]] == 0 || grid[cur[0]][cur[1]] > cur[2]+1)
                grid[cur[0]][cur[1]] = cur[2]+1;
            for(int i = -1; i < 2; i++){
                for(int j = -1; j < 2; j++){
                    if(!(i==0 && j==0)&&!(cur[0]+i==0 && cur[1]+j==0)){
                        if(cur[0]+i >= 0 && cur[0]+i < grid.length &&
                          cur[1]+j >= 0 && cur[1]+j < grid[0].length && 
                          grid[cur[0]+i][cur[1]+j] == 0){
                            int[] next = {cur[0]+i, cur[1]+j, cur[2]+1};
                            //mark next point under estimation
                            grid[next[0]][next[1]] = -2;
                            queue.add(next);
                        }
                    }
                }
            }
        }
        if(grid[grid.length-1][grid[0].length-1] == 0) return -1;
        return -1;
    }
}
