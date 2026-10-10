class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();
        boolean[][] seen = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == wordChar[0]) {
                    if (expand(seen, board, wordChar, 0, r, c))
                        return true;

                }
            }
        }

        return false;
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean expand(boolean[][] seen, char[][] board, char[] wordChar, int i, int r, int c) {
        if (i == wordChar.length)
            return true;

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != wordChar[i] || seen[r][c])
            return false; //not sure

        seen[r][c] = true; //valid and correct letter
        for (int[] dir : dirs) {
            if (expand(seen, board, wordChar, i + 1, r + dir[0], c + dir[1]))
                return true;
        }
        seen[r][c] = false;

        return false; //idk lowkey

    }
}
