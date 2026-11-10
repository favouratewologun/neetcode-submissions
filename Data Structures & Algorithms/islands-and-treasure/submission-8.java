class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0)
                    queue.offer(new int[]{r, c});
            }
        }
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

            
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int nr = pos[0] + dir[0];
                    int nc = pos[1] + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == Integer.MAX_VALUE) {
                        grid[nr][nc] = steps;
                        queue.offer(new int[]{nr, nc});
                    }

                }
            }
            steps++;
        }

    }
}
