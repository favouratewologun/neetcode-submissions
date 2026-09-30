class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    int[] pos = {r, c};
                    queue.offer(pos);
                }
            }
        }

        int mins = expand(queue, grid);

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }
        
        return mins;
        
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int expand(Queue<int[]> queue, int[][] grid) {
        int mins = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] coor = queue.poll();
                for (int[] dir : dirs) {
                    int nr = coor[0] + dir[0];
                    int nc = coor[1] + dir[1];

                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});

                    }
                }
            }
            if (!queue.isEmpty())
                mins++;

        }

        return mins;
        
    }
}
