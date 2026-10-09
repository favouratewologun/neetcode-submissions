class Solution {
    public int orangesRotting(int[][] grid) {
        int mins = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
                    
            }
        }

        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            boolean rotted = false;
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int nr = pos[0] + dir[0];
                    int nc = pos[1] + dir[1];

                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        rotted = true;
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            if (rotted)
                mins++;

        }

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
                    
            }
        }

        return mins;
        
        

    }
}
