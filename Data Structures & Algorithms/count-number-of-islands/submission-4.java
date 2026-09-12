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

    public final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void expand(char[][] grid, int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{r, c});
        grid[r][c] = '0';

        while(!q.isEmpty()) {
            int[] index = q.poll();

            r = index[0];
            c = index[1];

            for (int[] dir : dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == '1') {
                    grid[newR][newC] = '0';
                    q.offer(new int[]{newR, newC});
                }
            }
        }


    }
}


//         //go through the grid, find a one
//         //when we do, expand (w/ bfs) to mark all ones surrounding it as visited
//         //then increase number of islands

//         // Queue<int[]> queue = new ArrayDeque<>(); //keep track of indices
//         //HashSet<int[]> seen = new HashSet<>();
        
//         int islands = 0;

//         for (int r = 0; r < grid.length; r++) {
//             for (int c = 0; c < grid[r].length; c++) {
//                 int[] ind = new int[]{r, c};
//                 if (grid[r][c] == '1') { //if found island not seen before
//                     bfs(grid, ind);
//                     islands++;           
//                 } 
//             }
//         }

//         return islands;

//     }

//     private void bfs(char[][] grid, int[] ind) {
//         Queue<int[]> queue = new ArrayDeque<>();
//         queue.offer(ind);
//         grid[ind[0]][ind[1]] = 0; //make it water so its visited

//         while (!queue.isEmpty()) {
//             int[] currInd = queue.poll();

//             int r = currInd[0];
//             int c = currInd[1];

//             int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

//             for (int[] dir : dirs) {
//                 int rDir = dir[0];
//                 int cDir = dir[1];

//                 int newR = r + rDir;
//                 int newC = c + cDir;

//                 if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == '1') {
//                     //if within the bounds and is part of the island
//                     //seen.add(new int[]{newR, newC}); //mark as seen so know its part of island we alr know
//                     queue.offer(new int[]{newR, newC}); //add it to queue so we can check ITS neighbours
//                     grid[newR][newC] = '0';
//                 }

//             }
//         }

        
//     }
// }
