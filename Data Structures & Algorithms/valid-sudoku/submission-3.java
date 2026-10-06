class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> track = new HashSet<>();
        
        //all rows
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (Character.isLetterOrDigit(board[r][c]) && track.contains(board[r][c]))
                    return false;
                else if (Character.isLetterOrDigit(board[r][c]))
                    track.add(board[r][c]);
            }
            track.clear();
        }

        //all cols
        for (int c = 0; c < board[0].length; c++) {
            for (int r = 0; r < board.length; r++) {
                if (Character.isLetterOrDigit(board[r][c]) && track.contains(board[r][c]))
                    return false;
                else if (Character.isLetterOrDigit(board[r][c]))
                    track.add(board[r][c]);
            }
            track.clear();
        }

        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {
                for (int r = startRow; r < startRow + 3; r++) {
                    for (int c = startCol; c < startCol + 3; c++) {
                        if (Character.isLetterOrDigit(board[r][c]) && track.contains(board[r][c]))
                            return false;
                        else if (Character.isLetterOrDigit(board[r][c]))
                            track.add(board[r][c]);
                    }
                }
                track.clear();
            }
        }

        return true;
    }
}
