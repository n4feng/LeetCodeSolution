class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        oneLine = []
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                oneLine.append(grid[i][j])
        
        from collections import deque
        items = deque(oneLine)
        items.rotate(k)
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                grid[i][j] = items[i*len(grid[0])+j]
        
        return grid
