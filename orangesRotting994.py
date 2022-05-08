class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #each item in queue as [row, column, round]
        queue = []
        #all organges location
        oranges = []
        res = 0
        m,n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append([i,j,0])
                elif grid[i][j] == 1:
                    oranges.append([i,j])
        hori = [-1, 0, 0, 1]
        vert = [0, 1, -1, 0]
        while queue:
            rotten = queue.pop(0)
            for i in range(4):
                if rotten[0] + vert[i]>=0 and rotten[0] + vert[i] < m and rotten[1] + hori[i] >=0 and rotten[1] + hori[i] < n and grid[rotten[0] + vert[i]][rotten[1] + hori[i]] == 1:
                    grid[rotten[0] + vert[i]][rotten[1] + hori[i]] = 2
                    queue.append([rotten[0] + vert[i], rotten[1] + hori[i], rotten[2]+1])
                    res = rotten[2]+1
        for o in oranges:
            if grid[o[0]][o[1]] == 1:
                return -1
        return res
