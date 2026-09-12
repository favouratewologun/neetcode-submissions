class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int maxMin = 0;

        Queue<int[]> rotted = new ArrayDeque<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2)
                    rotted.offer(new int[]{r, c, 0});
            }
        }

        int mins = spread(grid, rotted);

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) //still fresh
                    return -1;
            }
        }

        return mins;

    
        
    }

    public final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int spread(int[][] grid, Queue<int[]> rotted) {
        //maybe q holds 3 ints, r, c, and time. add neighbours with time + 1 if not seen, or smth like that

        int maxMins = 0;

        while (!rotted.isEmpty()) {
            int[] index = rotted.poll();
            grid[index[0]][index[1]] = 0; //can set to empty bc about to add all neighbours it could poss harm
            int currMinutes = index[2];

            for (int[] dir : dirs) {
                int newR = index[0] + dir[0];
                int newC = index[1] + dir[1];

                if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == 1) {
                    grid[newR][newC] = 2;
                    rotted.offer(new int[]{newR, newC, currMinutes + 1}); //time is + 1 previous time
                    maxMins = Math.max(maxMins, currMinutes + 1); //max or min time
                }
            }
        }

        return maxMins;
    }

}