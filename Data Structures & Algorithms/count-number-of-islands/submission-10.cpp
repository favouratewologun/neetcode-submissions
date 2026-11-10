class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int islands = 0;

        for (int r = 0; r < grid.size(); r++) {
            for (int c = 0; c < grid[0].size(); c++) {
                if (grid[r][c] == '1') {
                    vector<int> point = {r, c};
                    expand(grid, point);
                    islands++;
                }
                
            }
        }

        return islands;

        
    }

    vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

void expand(vector<vector<char>>& grid, vector<int> point) {
    queue<vector<int>> queue;
    queue.push(point);

    while (!queue.empty()) {
        vector<int> pos = queue.front();
        grid[pos[0]][pos[1]] = 0;
        queue.pop();

        for (vector<int> dir : dirs) {
            int nr = pos[0] + dir[0];
            int nc = pos[1] + dir[1];

            if (nr >= 0 && nc >= 0 && nr < grid.size() && nc < grid[0].size() && grid[nr][nc] == '1') {
                grid[nr][nc] = 0;
                vector<int> newPos = {nr, nc};
                queue.push(newPos);
            }
        }
        
    }
}

};

