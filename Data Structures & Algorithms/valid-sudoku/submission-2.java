class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> check = new HashSet<>();

        //each row
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (Character.isDigit(board[r][c]) && check.contains(board[r][c]))
                    return false;
                else
                    check.add(board[r][c]);
            }
            check.clear();
        }

        //each col
        for (int c = 0; c < board[0].length; c++) {
            for (int r = 0; r < board.length; r++) {
                if (Character.isDigit(board[r][c]) && check.contains(board[r][c]))
                    return false;
                else
                    check.add(board[r][c]);
            }
            check.clear();
        }

        //each square
        // int sqRow = 0;
        // int sqCol = 0;

        for (int sqRow = 0; sqRow < board.length; sqRow += 3) {
            for (int sqCol = 0; sqCol < board[0].length; sqCol += 3) {
                for (int r = sqRow; r < sqRow + 3; r++) {
                    for (int c = sqCol; c < sqCol + 3; c++) {
                        if (Character.isDigit(board[r][c]) && check.contains(board[r][c]))
                            return false;
                        check.add(board[r][c]);
                    }
                }
                check.clear();
            }
        }

        return true;
        
    }
}
