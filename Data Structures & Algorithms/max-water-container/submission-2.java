class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;

        int lMax = heights[l];
        int rMax = heights[r];

        int maxWater = 0;

        while (l < r) {
            if (heights[l] < heights[r]) {
                if (heights[l] < lMax) {
                    maxWater = Math.max(maxWater, (r - l) * heights[l]);
                } else {
                    lMax = heights[l];
                    maxWater = Math.max(maxWater, (r - l) * heights[l]);
                }
                    
                l++;
            } else {
                if (heights[r] < rMax) {
                    maxWater = Math.max(maxWater, (r - l) * heights[r]);
                } else {
                    rMax = heights[r];
                    maxWater = Math.max(maxWater, (r - l) * heights[r]);
                }
                r--;
            }
        }

        return maxWater;
        
    }
}
