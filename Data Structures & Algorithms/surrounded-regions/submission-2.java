class Solution {
    public void solve(char[][] board) {
       

        for (int r = 0; r < board.length; r++) {
            if (board[r][0] == 'O')
                expand(board, r, 0);
            if (board[r][board[0].length - 1] == 'O')
                expand(board, r, board[0].length - 1);
        }

        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == 'O')
                expand(board, 0, c);
            if (board[board.length - 1][c] == 'O')
                expand(board, board.length - 1, c);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'S')
                    board[r][c] = 'O';
                else if (board[r][c] == 'O')
                    board[r][c] = 'X';
            }
        }
        
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void expand(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O')
            return;
            //if invalid or alr seen or not O

        board[r][c] = 'S';
        for (int[] dir : dirs) {
            expand(board, r + dir[0], c + dir[1]);
        }

    }
}
