class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> chest = new ArrayDeque<>();
        int steps = 1;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0)
                    chest.offer(new int[]{r, c});
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!chest.isEmpty()) {
            int size = chest.size();
            for (int i = 0; i < size; i++) {
                int[] pos = chest.poll();
                for (int[] dir: dirs) {
                    int nr = pos[0] + dir[0];
                    int nc = pos[1] + dir[1];
                    
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == Integer.MAX_VALUE) {
                        grid[nr][nc] = steps;
                        chest.offer(new int[]{nr, nc});
                    }
                }
            }
            steps++;

        }
        

    }
}
