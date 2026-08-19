class Solution {
    public boolean isValidSudoku(char[][] board) {

        //check rows
        for (int i = 0; i < board.length; i++) {
            char [] row = board[i];
            //for (char elem : row)
                //System.out.println("elem " + elem);
            HashMap<Character, Integer> numCount = new HashMap<Character, Integer>();
            for (char num : row) {
                if (num != '.')
                    numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            }

            for (char num : numCount.keySet()) {
                if (numCount.get(num) > 1)
                    return false;
            }

        }

        System.out.println("rows are good");
        // check cols
        for (int i = 0; i < board.length; i++) {
            char [] column = new char [9];
            for (int j = 0; j < column.length; j++) 
                column[j] = board[j][i]; // might need to check logic on this

            HashMap<Character, Integer> numCount = new HashMap<Character, Integer>();
            for (char num : column) {
                if (num != '.')
                    numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            }

            for (char num : numCount.keySet()) {
                if (numCount.get(num) > 1)
                    return false;
            }
            

        }
        System.out.println("cols are good");
        //check boxs
        
        int startRow = 0;
        int endRow = 3;
        int countRow = 0;   
        int startCol = 0;
        int endCol = 3;

        for (int i = 0; i < 9; i++) {
            
            char[] numsInBox = new char[9];
            

            int ind = 0;
            for (int row = startRow; row < endRow; row++) {

                
                int countCol = 0;
                
                for (int col = startCol; col < endCol; col++) {

                    numsInBox[ind] = (board[row][col]);
                    ind++;
                    countCol++;
                    
                }

               
               
                
                

                
                
            }
             System.out.println(numsInBox);
            countRow++;
            startRow += 3;
            endRow +=3;

             if (countRow >= 3 && countRow % 3 == 0) {
                countRow = 0;
                startCol += 3;
                endCol += 3;
                startRow = 0;
                endRow = 3;
             }


            

           
            HashMap<Character, Integer> numCount = new HashMap<Character, Integer>();
                for (char num : numsInBox) {
                    if (num != '.')
                        numCount.put(num, numCount.getOrDefault(num, 0) + 1);
                }

                for (char num : numCount.keySet()) {
                    if (numCount.get(num) > 1)
                        return false;
                }
        }

        return true;
        
    }
}
