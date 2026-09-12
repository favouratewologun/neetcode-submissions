class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        final int ROWS = heights.length;
        final int COLS = heights[0].length;
        
        List<List<Integer>> res = new ArrayList<>();

        HashSet<Integer> pacific = new HashSet<>();
        HashSet<Integer> atlantic = new HashSet<>();

        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, pacific, -1);
            dfs(heights, r, COLS - 1, atlantic, -1);
        }

        for (int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, pacific, -1);
            dfs(heights, ROWS - 1, c, atlantic, -1);
        }

        pacific.retainAll(atlantic);
        //create new, have to convert back to nromal
        for (int key : pacific) {
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add(key / COLS);
            pos.add(key % COLS);

            res.add(pos);
        }

        return res;

    }

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    private void dfs(int[][] heights, int r, int c, HashSet<Integer> visited, int prevH) {
        final int ROWS = heights.length;
        final int COLS = heights[0].length;

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || visited.contains(r * COLS + c) || heights[r][c] < prevH)
            return; //if out of bounds or already done it or water couldnt flow in, stop
        
        visited.add(r * COLS + c); //in bounds, not visited before, and water can flow in. so add neighbours

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(heights, nr, nc, visited, heights[r][c]);
        }
       
        
    }
    
}
