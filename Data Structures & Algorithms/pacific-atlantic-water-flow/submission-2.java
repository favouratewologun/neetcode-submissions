class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        boolean[][] seenPac = new boolean[heights.length][heights[0].length];
        boolean[][] seenAt = new boolean[heights.length][heights[0].length];
        
        for (int r = 0; r < heights.length; r++) {
            expand(pacific, r, 0, seenPac, heights, -1);
            expand(atlantic, r, heights[0].length - 1, seenAt, heights, -1);
        }

        for (int c = 0; c < heights[0].length; c++) {
            expand(pacific, 0, c, seenPac, heights, -1);
            expand(atlantic, heights.length - 1, c, seenAt, heights, -1);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    ArrayList<Integer> pos = new ArrayList<>(Arrays.asList(r, c));
                    res.add(pos);
                }
            }
        }

        return res;
        
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void expand(boolean[][] ocean, int r, int c, boolean[][] seen, int[][] heights, int prev) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || seen[r][c] || prev > heights[r][c]) {
            return; 
            //if invalid or already done this or previous >= self (water cant flow in)
        }

        ocean[r][c] = true;
        seen[r][c] = true;

        for (int[] dir : dirs) {
            expand(ocean, r + dir[0], c + dir[1], seen, heights, heights[r][c]);
        }

    }
}
