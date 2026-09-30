class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        
        // //want to assign a key = r * # cols + c
        // final 
        
        HashSet<Integer> pacific = new HashSet<>();
        HashSet<Integer> atlantic = new HashSet<>();


        for (int r = 0; r < heights.length; r++) {
            expand(r, 0, pacific, heights);
            expand(r, heights[0].length - 1, atlantic, heights);
        }

        for (int c = 0; c < heights[0].length; c++) {
            expand(0, c, pacific, heights);
            expand(heights.length - 1, c, atlantic, heights);
        }

        //running dfs to add places where it can flow on sight. want it to update these hashsets
        //pass hashsets in, but also pass all poss coors in?
        pacific.retainAll(atlantic);

        List<List<Integer>> res = new ArrayList<>();
        for (int key : pacific) {
            int r = key / heights[0].length;
            int c = key % heights[0].length;
            ArrayList<Integer> add = new ArrayList<>();
            add.add(r);
            add.add(c);
            res.add(add);
        }

        return res;
        
        // return pacific.retainAll(atlantic); //intersection
    }


    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void expand(int r, int c, HashSet<Integer> ocean, int[][] heights) {
        int COLS = heights[0].length;
        int key = r * COLS + c;
        // int key = r * COLS + c;

        if (ocean.contains(key)) //if alr seen, dont need to do again
            return;


        ocean.add(key);

        for (int [] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && heights[r][c] <= heights[nr][nc])
                expand(nr, nc, ocean, heights);
        }

    }
}
