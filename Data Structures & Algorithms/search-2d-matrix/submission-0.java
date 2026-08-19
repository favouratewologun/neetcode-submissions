class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int tRow = 0;
        int bRow = matrix.length - 1;

        final int MATRIX_LENGTH = matrix[0].length;

        while (tRow <= bRow) {
            int mRow = (tRow + bRow) / 2;
            int mNum = matrix[mRow][0];
            int mNumEnd = matrix[mRow][MATRIX_LENGTH - 1];

            
            if (target < mNum) {
                //less than entire row 
                bRow = mRow - 1;
            } else if (target > mNumEnd) {
                // greater than entire row
                tRow = mRow + 1;
            } else {
                int l = 0;
                int r = MATRIX_LENGTH - 1;

                while (l <= r) {
                    int m = (l + r) / 2;
                    if (matrix[mRow][m] < target)
                        l = m + 1;
                    else if (matrix[mRow][m] > target)
                        r = m - 1;
                    else
                        return true;

                }

                return false;

            }

        }

        return false;

        //get correct row first, then correct col
        
    }
}
