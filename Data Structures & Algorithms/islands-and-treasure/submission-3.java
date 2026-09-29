class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        //bfs, get all vals around if, if bw 0 and size of grid (10000) then good
        //so for every location in the grid thats bw 0 and inf, expand.
        //expand by checking in all 4 dirs, taking the min and adding 1.
        //add to queue, then continue.
        //so just checking all 4 dirs for all
        //only if already inf tho?\

        //but do a mulisource bfs so start at the one closest, so im going to need a quwu

        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    int[] pos = {r, c};
                    queue.offer(pos);
                }
            }
        }

        traverse(queue, grid);
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
 
    private void traverse(Queue<int[]> queue, int[][] grid) {

        while (!queue.isEmpty()) {
            int[] coor = queue.poll();
            int r = coor[0];
            int c = coor[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == Integer.MAX_VALUE) { //we want to update it only if its smaller than what we curr have
                    grid[nr][nc] = grid[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                    
                }

            }
        }
    }
}
