class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int tRow = 0;
        int bRow = matrix.length - 1;
        final int START_ROW = 0;
        final int END_ROW = matrix[0].length - 1;

        while (tRow <= bRow) {
            int mRow = (tRow + bRow) / 2;
            int startNum = matrix[mRow][START_ROW];
            int endNum = matrix[mRow][END_ROW];

            if (target < startNum) {
                bRow = mRow - 1;
            } else if (target > endNum) {
                tRow = mRow + 1;
            } else { //either correct row or DNI
                int l = 0;
                int r = END_ROW;

                while (l <= r) {
                    int m = (l + r) / 2;
                    if (matrix[mRow][m] < target) 
                        l = m + 1;
                    else if (matrix[mRow][m] > target) {
                        r = m - 1;
                    } else //found target
                        return true;
                }

                //if in the correct row but couldnt find the val within the row. dne. false.
                return false;

            }

        }
        return false;
        
    }
}
