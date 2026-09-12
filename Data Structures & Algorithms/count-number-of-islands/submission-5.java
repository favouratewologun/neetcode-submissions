class Solution {
    public int numIslands(char[][] grid) {

        //go through the grid.
        //if we hit a 1, blow it up (expand)
        //after blown up, we sunk that island, so can increment numislands
        //return num islands

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
        //want to do a BFS with it

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) { //if empty, no where around our island has land...we've found the full island
            int[] pos = q.poll();
            for (int[] dir : dirs) {
                int newR = pos[0] + dir[0];
                int newC = pos[1] + dir[1];

                if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == '1') {
                    grid[newR][newC] = 0;
                    q.offer(new int[]{newR, newC});
                }
            }

        }
    }
}
