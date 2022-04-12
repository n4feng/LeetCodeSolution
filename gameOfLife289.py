class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        directions = [-1,0,1]
        rows = len(board)
        cols = len(board[0])
        #-1 stand for cell was alive but dead at turn
        # 2 stand for cell was dead but alive at turn
        for i in range(rows):
            for j in range(cols):
                sum = 0
                for x in directions:
                    for y in directions:
                        if not (directions[x]==0 and directions[y] == 0):
                            r = i+directions[x]
                            c = j+directions[y]
                            if r<rows and r>=0 and c<cols and c>=0 and abs(board[r][c])==1:
                                sum+=1
                # Rule 1 or Rule 3
                if board[i][j] == 1 and (sum < 2 or sum > 3):
                    # -1 signifies the cell is now dead but originally was live.
                    board[i][j] = -1
                # Rule 4
                if board[r][j] == 0 and sum == 3:
                    # 2 signifies the cell is now live but was originally dead.
                    board[i][j] = 2
        # Get the final representation for the newly updated board.
        for i in range(rows):
            for j in range(cols):
                if board[i][j] > 0:
                    board[i][j] = 1
                else:
                    board[i][j] = 0
