class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(expand(grid, r, c), maxArea);
                }
            }
        }
        
        return maxArea;
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int expand(int[][] grid, int r, int c) {
        int area = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        grid[r][c] = 0;
        area++;

        while (!queue.isEmpty()) {
            int[] coor = queue.poll();

            for (int[] dir : dirs) {
                int nr = coor[0] + dir[0];
                int nc = coor[1] + dir[1];

                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                    queue.offer(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                    area++;
                }
            }
        }

        return area;


    }
}

//go through all the areas, if find the start of an island expand it
//update max island -- so expansion returns area
