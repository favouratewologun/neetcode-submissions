class Solution {
    public int orangesRotting(int[][] grid) {
        //keep track of all starting rotting in a queue...then do bfs and similar ot islands

        Queue<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2)
                    q.offer(new int[]{r, c, 0});
            }
        }

        int mins = expand(q, grid);

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) //unaffected fresh fruit
                    return -1;
            }
        }

        return mins;
           
    }

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int expand(Queue<int[]> q, int[][] grid) {
        int maxMins = 0;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int mins = pos[2];

            grid[pos[0]][pos[1]] = 0; //done expanding from here, bc adding all neighbours now

            for (int[] dir : dirs) {
                int nr = pos[0] + dir[0];
                int nc = pos[1] + dir[1];

                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2; //make new rotten fruit
                    q.offer(new int[]{nr, nc, mins + 1});
                    maxMins = Math.max(maxMins, mins + 1);
                } 
            }

            
        }

        return maxMins;
    }
}
