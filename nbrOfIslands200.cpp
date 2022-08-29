class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int count(0);
        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid[0].size(); j++){
                if(grid[i][j] == '1'){
                    count+=1;
                    removeIsland(grid, i, j);
                }
            }
        }
        return count;
    }
    
    void removeIsland(vector<vector<char>>& grid, size_t x, size_t y){
        if(x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size())
            return;
        if(grid[x][y] == '1'){
            grid[x][y] = '0';
            int hor[4] = {-1, 0, 0, 1};
            int ver[4] = {0, -1, 1, 0};
            
            for(int i = 0; i < 4; i++){
                removeIsland(grid, x+hor[i], y+ver[i]);
            }
        }
        return;
    }
};
