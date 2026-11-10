class Solution {
    public boolean isValidSudoku(char[][] board) {
        //go through all rows, confirm good

        for (int r = 0; r < 9; r++) {
            HashSet<Integer> nums = new HashSet<>();
            
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.' && nums.contains(Integer.valueOf(board[r][c]))) {
                    return false;
                } else if (board[r][c] != '.') { //but is an int
                    nums.add(Integer.valueOf(board[r][c]));
                }
            }

            nums.clear();
        }

        for (int c = 0; c < 9; c++) {
            HashSet<Integer> nums = new HashSet<>();
            
            for (int r = 0; r < 9; r++) {
                if (board[r][c] != '.' && nums.contains(Integer.valueOf(board[r][c]))) {
                    return false;
                } else if (board[r][c] != '.') { //but is an int
                    nums.add(Integer.valueOf(board[r][c]));
                }
            }

            nums.clear();
        }

        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                HashSet<Integer> nums = new HashSet<>();

                for (int thisR = r; thisR < r + 3; thisR++) {
                    for (int thisC = c; thisC < c + 3; thisC++) {
                        if (board[thisR][thisC] != '.' && nums.contains(Integer.valueOf(board[thisR][thisC]))) {
                            return false;
                        } else if (board[thisR][thisC] != '.') { //but is an int
                            nums.add(Integer.valueOf(board[thisR][thisC]));
                        }

                    }
                }

                nums.clear();


            }
            
        }

        return true;



        //go through all cols, confirm good
        //go through all boxes, confirm good
    }
}
