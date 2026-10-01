class Solution {
    public void solve(char[][] board) {
        //capture all surrounded regions
        //expand it all the way. once expanded, if any touching edge then continue
        //if not touching edge replace all with once

        //iterate through the graph --> later amrk keys as seen, so if there, ignore it
        //nvm, do dfs to save time

        for (int r = 0; r < board.length; r++) {
            if (board[r][0] == 'O') {
                board[r][0] = 'S';
                expand(board, r, 0);
            }
            if (board[r][board[0].length - 1] == 'O') {
                board[r][board[0].length - 1] = 'S';
                expand(board, r, board[0].length - 1);

            }
            
        }

        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == 'O') {
                board[0][c] = 'S';
                expand(board, 0, c);
            }
            if (board[board.length - 1][c] == 'O') {
                board[board.length - 1][c] = 'S';
                expand(board, board.length - 1, c);

            }
        }
        //expand all from edges.
        //now done, any S stays O, any O becomes X

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'S')
                    board[r][c] = 'O';
                else if (board[r][c] == 'O')
                    board[r][c] = 'X';
            }
        }
        
    }

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private void expand(char[][] board, int r, int c) {
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            //valid value and equal to O
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 'O') {
                board[nr][nc] = 'S';
                expand(board, nr, nc); //check all its neighbours
            } 
        }
    }

}
