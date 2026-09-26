class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    expand(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void expand(char[][] grid, int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{r, c});
        grid[r][c] = '0';

        while(!queue.isEmpty()) {
            int[] loc = queue.poll();

            for (int[] dir : dirs) {
                int nr = loc[0] + dir[0];
                int nc = loc[1] + dir[1];

                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
                    //if within bounds and part of the islands
                    queue.offer(new int[]{nr, nc}); //so later all its neighbours can be check
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
