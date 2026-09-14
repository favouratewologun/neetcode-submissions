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

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void expand(char[][] grid, int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        grid[r][c] = '0';

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for (int [] dir : dirs) {
                int nr = pos[0] + dir[0];
                int nc = pos[1] + dir[1];

                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }

    }
}
