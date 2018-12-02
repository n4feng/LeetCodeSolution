class Solution {
    public void solve(char[][] board) {
        if(board.length == 0) return;
        if(board[0].length == 0) return;
        
        
        int bheight = board.length;
        int bwidth = board[0].length;
        for(int i = 0; i < bwidth; i++){//first and last row
            if(board[0][i] == 'O') markSafe(board,0,i);
            if(board[bheight-1][i] == 'O') markSafe(board,bheight-1,i);
        }
        for(int i = 1; i < bheight-1; i++){//first and last column (without corner that repeated with raws)
            if(board[i][0] == 'O') markSafe(board,i,0);
            if(board[i][bwidth-1] == 'O') markSafe(board,i,bwidth-1);
        }
        for(int i = 0; i < bheight; i++){
            for(int j =0; j < bwidth; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }
    private void markSafe(char[][] board, int row, int column){
        board[row][column] = 'S';
        //check four dierctrion if possible
        int bheight = board.length;
        int bwidth = board[0].length;
        if(row < bheight-1){//down
            if(board[row+1][column] == 'O') markSafe(board,row+1,column);
        }
        if(row > 0){//up
            if(board[row-1][column] == 'O') markSafe(board,row-1,column);
        }
        if(column < bwidth-1){//right
            if(board[row][column+1] == 'O') markSafe(board,row,column+1);
        }
        if(column > 0){//left
            if(board[row][column-1] == 'O') markSafe(board,row,column-1);
        }
    }
}