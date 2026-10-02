class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();

        boolean exists = false;
        boolean[][] used = new boolean[board.length][board[0].length]; //rep if used in dfs

        

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == wordChar[0]) {
                    exists = backtracking(0, r, c, wordChar, board, used);
                    if (exists)
                        return exists;
                }
                used[r][c] = false;
            }
        }

        return exists;
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean backtracking(int i, int r, int c, char[] wordChar, char[][] board, boolean[][] used) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length)
            return false;

        if (board[r][c] != wordChar[i] || used[r][c])
            return false;

        if (i == wordChar.length - 1) //found entire work
            return true;

        used[r][c] = true;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            boolean found = backtracking(i + 1, nr, nc, wordChar, board, used);
            if (found)
                return true;
            
        }
        used[r][c] = false;

        return false;

    }


}
